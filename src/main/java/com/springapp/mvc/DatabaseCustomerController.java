package com.springapp.mvc;

import fileActions.CustomLogger;
import fileActions.ReadFile;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import persistance.CustomerSpringService;
import persistance.DbCustomerEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by r730819 on 6/24/2016.
 */

@Controller
public class DatabaseCustomerController {

    private CustomerSpringService customerSpringService;

    @Autowired(required = true)
    @Qualifier(value = "customerSpringService")
    public void setCustomerSpringService(CustomerSpringService customerSpringService){
        this.customerSpringService = customerSpringService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model){
        model.addAttribute("DbCustomerEntity", new DbCustomerEntity());
        model.addAttribute("listCustomers", this.customerSpringService.listCustomers());
        return "viewCustomers";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") DbCustomerEntity dbCustomerEntity){
        if(dbCustomerEntity.getId() == 0){
            this.customerSpringService.addCustomer(dbCustomerEntity);
        }
        else{
            this.customerSpringService.updateCustomer(dbCustomerEntity);
        }

        return "redirect:/customers";
    }

    @RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
        this.customerSpringService.removeCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("DbCustomerEntity", this.customerSpringService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerSpringService.listCustomers());

        return "viewCustomers";

    }

    /**
     * Controller receives a file upload from post
     * and proceeds to create a new temp file on the
     * Tomcat server root.  The file is passed into
     * a function to begin parsing and eventually
     * adding to the database.
     */
    @RequestMapping(value = "/uploadCustomerViaFile", method = RequestMethod.POST)
    String uploadFileHandler(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");

                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + "tmpCustomerFile"+ RandomStringUtils.randomNumeric(5)+".txt");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                CustomLogger.createLogMsgAndSave("Server File Location="
                        + serverFile.getAbsolutePath());

                ReadFile.readAndCreateObjects(serverFile);

                return "redirect:/customers";
            } catch (Exception e) {
                return "redirect:/customers";
            }
        } else {
                return "redirect:/customers";
        }
    }
}
