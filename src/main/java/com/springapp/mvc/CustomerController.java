package com.springapp.mvc;

import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class CustomerController {

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView customer() {
        return new ModelAndView("customer", "command", new Customer());
        /**
         * we have passed a blank Customer object in the ModelAndView object with name "command" because
         * the spring framework expects an object with name "command" if you are using <form:form> tags in your JSP file.
         */
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("SpringWeb") Customer customer,
                              ModelMap model) {
        model.addAttribute("name", customer.getLastName());
        model.addAttribute("name", customer.getLastName());
        model.addAttribute("name", customer.getFirstName());
        model.addAttribute("name", customer.getEmailAddress());
        model.addAttribute("name", customer.getHomeAddress());
        model.addAttribute("name", customer.getCity());
        model.addAttribute("name", customer.getState());
        model.addAttribute("name", customer.getZipCode());
        model.addAttribute("name", customer.getTimeStamp());
        return "result";
    }
}

