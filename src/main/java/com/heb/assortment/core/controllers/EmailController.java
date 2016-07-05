package com.heb.assortment.core.controllers;

import com.heb.assortment.core.models.EmailMessageTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heb.assortment.util.email.CreateEmailMessage;
import com.heb.assortment.util.email.SendCustomersViaEmail;

import javax.servlet.http.HttpServletRequest;

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
    public String getEmailPage(Model model, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            model.addAttribute("emailMessageTemplate", new EmailMessageTemplate(ConfigFileController.getMailFrom()));
            return "email";
        }else{
            return "redirect:/login";
        }
    }

    /**
     * Receives an EmailMessageTemplate object
     * and pulls all the necessary information
     * to send the email.
     *
     * @param email the email message with all the
     *              details to send it
     *
     * @return The message to display in the browser
     * after the sending attempt is complete
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public @ResponseBody
    String sendEmail(@ModelAttribute("emailMessageTemplate") EmailMessageTemplate email, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){

            if(SendCustomersViaEmail.sendEmail(email.getToEmail(), email.getFromEmail(), email.getSubject(),
                    email.getMessage())){

                return "Email successfully sent";
            }else{

                return "Unable to send email";
            }

        }else{
            return "please login";
        }
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
    String populateSortedCustomers(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return CreateEmailMessage.getSortedEmail();
        }else{
            return "please log in";
        }
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
    String populateUnsortedCustomers(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return CreateEmailMessage.getUnsortedEmail();
        }else{
            return "please log in";
        }
    }


}
