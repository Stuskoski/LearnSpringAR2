package com.springapp.mvc;

import databaseActions.DatabaseConnections;
import fileActions.CreateTempCustomerFile;
import fileActions.CustomLogger;
import fileActions.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import persistance.hibernateObjects.customer.CustomerSpringService;
import persistance.hibernateObjects.customer.DbCustomerEntity;

import java.io.File;

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

        //if a database connection can be made, redirect to view customers with the data, else go back home
        if(DatabaseConnections.getDB()!=null){
            model.addAttribute("DbCustomerEntity", new DbCustomerEntity());
            model.addAttribute("listCustomers", this.customerSpringService.listCustomers());
            DatabaseConnections.clearDBConnection();
            return "viewCustomers";
        }else{
            return null; //todo redirect to error page
        }

    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public @ResponseBody
    String addCustomer(@ModelAttribute("customer") DbCustomerEntity dbCustomerEntity){
        try {
            if(dbCustomerEntity.getId() == 0){
                this.customerSpringService.addCustomer(dbCustomerEntity);
                return "Customer successfully added";
            }
            else{
                this.customerSpringService.updateCustomer(dbCustomerEntity);
                return "Customer exists, customer updated";
            }
        }catch (Exception e){
            return "An error has occurred.  Unable to upload customer";
        }
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
    public @ResponseBody
    String uploadFileHandler(@RequestParam("file") MultipartFile file) {
        CustomLogger.createLogMsgAndSave("file called");
        if (!file.isEmpty()) {
            try {
                //create temp file
                File tempFile = CreateTempCustomerFile.createFile(file);

                //Calls read file to generate DbCustomerEntity array list and then loop through it
                for (DbCustomerEntity customer : ReadFile.readAndCreateObjects(tempFile)){
                    if(customer.getId() == 0){
                        this.customerSpringService.addCustomer(customer);
                    }
                    else{
                        this.customerSpringService.updateCustomer(customer);
                    }
                }

                return "Customers uploaded successfully";
            } catch (Exception e) {
                CustomLogger.createLogMsgAndSave("Unable to upload customer list: " + e.getMessage());
                return "Unable to upload customers";
            }
        } else {
            CustomLogger.createLogMsgAndSave("Unable to upload customer list: File empty!");
            return "File empty!";
        }
    }
}
