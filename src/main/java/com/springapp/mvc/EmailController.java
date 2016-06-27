package com.springapp.mvc;

import models.Customer;
import models.EmailMessageTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.SendCustomersViaEmail;

/**
 * Created by r730819 on 6/27/2016.
 */

@Controller
@RequestMapping("/email")
public class EmailController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("emailMessageTemplate", new EmailMessageTemplate());
        return "email";
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute("emailMessageTemplate") EmailMessageTemplate email){
        SendCustomersViaEmail.sendEmail(email.getToEmail(), email.getFromEmail(), email.getSubject(),
                email.getMessage());
        return "redirect:/email";
    }

    @RequestMapping(value = "/populateSortedCustomers", method = RequestMethod.GET)
    public String sendTXSortedEmail(){
        //SendCustomersViaEmail.sendEmail("rutkoski.augustus@heb.com", "rutkoski.augustus@heb.com", "Test Subject", "Test MSG");
        return "redirect:/email";
    }

    @RequestMapping(value = "/populateUnsortedCustomers", method = RequestMethod.GET)
    public String sendUnsortedEmail(){
        //SendCustomersViaEmail.sendUnsortedEmail("rutkoski.augustus@heb.com", "rutkoski.augustus@heb.com", "Test Subject", "Test MSG");
        return "redirect:/email";
    }


}
