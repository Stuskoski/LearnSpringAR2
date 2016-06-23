package com.springapp.mvc;

import databaseActions.UploadCustomerIntoDatabase;
import fileActions.CustomLogger;
import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by r730819 on 6/22/2016.
 *
 * Controller to load the upload customers
 * page as well as run the necessary methods
 * to upload a customer file or just a single
 * customer
 */

@Controller
@RequestMapping("/uploadCustomers")
public class DatabaseUploadCustomersController {

    @RequestMapping(value = "/textFileUpload", method = RequestMethod.GET)
    public String getUploadCustomerViaTextFilePage(){ return "uploadCustomersViaTextFile";}

    @RequestMapping(value = "/webFormUpload", method = RequestMethod.GET)
    public String getUploadCustomerViaWebFormPage(Model model){
        model.addAttribute("customer", new Customer());
        return "uploadCustomersViaWebForm";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer")Customer customer, ModelMap model){

        model.addAttribute("name", customer.getFirstName());
        model.addAttribute("name", customer.getLastName());
        model.addAttribute("name", customer.getEmailAddress());
        model.addAttribute("name", customer.getHomeAddress());
        model.addAttribute("name", customer.getCity());
        model.addAttribute("name", customer.getState());
        model.addAttribute("name", customer.getZipCode());

        UploadCustomerIntoDatabase.uploadSingleCustomer(customer);

        CustomLogger.createLogMsgAndSave("Form Submitted");

        return "uploadCustomers";
    }
}
