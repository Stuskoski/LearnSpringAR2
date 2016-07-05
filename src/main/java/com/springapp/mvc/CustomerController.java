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

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Customer controller that will handle
 * all the modifying, deleting, adding
 * customer functions
 *
 * Created by r730819 on 6/24/2016.
 */

@Controller
public class CustomerController {

    private CustomerSpringService customerSpringService;

    @Autowired(required = true)
    @Qualifier(value = "customerSpringService")
    public void setCustomerSpringService(CustomerSpringService customerSpringService){
        this.customerSpringService = customerSpringService;
    }


    /**
     * Anytime the user calls /customers page this method
     * will make a quick check if the db is available
     * and then will create a list will all
     * customers in it.
     *
     * @param model Model to add entity and customers to
     * @param request Check if session available
     * @return string to display page
     */
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            //if a database connection can be made, redirect to view customers with the data, else go back home
            if(DatabaseConnections.getDB()!=null){
                model.addAttribute("DbCustomerEntity", new DbCustomerEntity());
                model.addAttribute("listCustomers", this.customerSpringService.listCustomers());
                DatabaseConnections.clearDBConnection();
                return "viewCustomers";
            }else{
                return null; //todo redirect to error page
            }
        }else{
            return "redirect:/login";
        }
    }


    /**
     * Controller to add a user to
     * the database.  Accepts a POST
     * request with the customers
     * info.
     *
     * @param dbCustomerEntity POST variable autowired with customers information
     * @param request Check if session available
     * @return A string response wether to login or customer action
     */
    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public @ResponseBody
    String addCustomer(@ModelAttribute("customer") DbCustomerEntity dbCustomerEntity, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            try {
                if(dbCustomerEntity.getId() == 0){
                    this.customerSpringService.addCustomer(dbCustomerEntity);
                    CustomLogger.createLogMsgAndSave(
                            "Customer saved successfully, Customer Details="+dbCustomerEntity.toString());
                    return "Customer added";
                }
                else{
                    this.customerSpringService.updateCustomer(dbCustomerEntity);
                    return "Customer updated";
                }
            }catch (Exception e){
                CustomLogger.createLogMsgAndSave("An error has occurred.  Unable to upload customer");
                return "Customer error";
            }
        }else{
            return "Please log in";
        }
    }

    /**
     * Controller to remove a user with
     * their id in the url
     *
     * @param id ID of the customer to delete
     * @param request Check if user has session
     * @return redirect to either login page or customers
     */
    @RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            this.customerSpringService.removeCustomer(id);
            return "redirect:/customers";
        }else{
            return "redirect:/login";
        }
    }


    /**
     * Controller that will receives a GET
     * request to return the page of viewCustomers.
     *
     * @param request Check if user has session open
     * @return A page view or redirect url string
     */
    @RequestMapping(method = RequestMethod.GET, value = "/viewCustomers")
    public String getViewCustomersPage(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "viewCustomers";
        }else{
            return "redirect:/login";
        }
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
    String uploadFileHandler(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if(request.getSession().getAttribute("userLoggedIn") != null){
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
        }else{
            return "redirect:/login";
        }
    }
}
