package com.springapp.mvc;

import models.Customer;
import models.EmailMessageTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.CreateEmailMessage;
import util.SendCustomersViaEmail;

/**
 * Controller class to handle all the
 * functions with email.
 *
 * Created by r730819 on 6/27/2016.
 */

@Controller
@RequestMapping("/email")
public class EmailController {

    /**
     * Receives a new EmailMessageTemplate object
     * to bind to the form on the webpage.
     * On submit this object will be used in
     * other controllers.
     *
     * @param model New model to be bound to
     * @return Returns string email to view that webpage
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("emailMessageTemplate", new EmailMessageTemplate());
        return "email";
    }

    /**
     * Receives an EmailMessageTemplate object
     * and pulls all the necessary information
     * to send the email.
     *
     * @param email the email message with all the
     *              details to send it
     *
     * @return redirection to email view
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute("emailMessageTemplate") EmailMessageTemplate email){
        SendCustomersViaEmail.sendEmail(email.getToEmail(), email.getFromEmail(), email.getSubject(),
                email.getMessage());
        return "redirect:/email";
    }

    /**
     * Calls Create sorted email to loop
     * through all the customers and generate
     * an email message and return it.
     *
     * @return email body
     */
    @RequestMapping(value = "/populateSortedCustomers", method = RequestMethod.GET)
    public @ResponseBody
    String populateSortedCustomers(){
        return CreateEmailMessage.getSortedEmail();
    }

    /**
     * Calls Create unsorted email to loop
     * through all the customers and generate
     * an email message and return it.
     *
     * @return email body
     */
    @RequestMapping(value = "/populateUnsortedCustomers", method = RequestMethod.GET)
    public @ResponseBody
    String populateUnsortedCustomers(){
        return CreateEmailMessage.getUnsortedEmail();
    }


}
