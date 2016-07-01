package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persistance.hibernateObjects.customer.DbCustomerEntity;

import javax.servlet.http.HttpServletRequest;


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
    public String getUploadCustomerViaTextFilePage(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "uploadCustomersViaTextFile";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/webFormUpload", method = RequestMethod.GET)
    public String getUploadCustomerViaWebFormPage(Model model, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            model.addAttribute("customer", new DbCustomerEntity());
            return "uploadCustomersViaWebForm";
        }else{
            return "redirect:/login";
        }


    }
}
