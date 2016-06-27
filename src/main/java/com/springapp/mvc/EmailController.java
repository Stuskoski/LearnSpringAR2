package com.springapp.mvc;

import org.springframework.stereotype.Controller;
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
    public String getLoginPage(){return "email";}

    @RequestMapping(value = "/sendSortedEmail", method = RequestMethod.GET)
    public String sendTXSortedEmail(){
        SendCustomersViaEmail.sendSortedEmail("rutkoski.augustus@heb.com", "rutkoski.augustus@heb.com", "Test Subject");
        return "redirect:/email";
    }

    @RequestMapping(value = "/sendUnsortedEmail", method = RequestMethod.GET)
    public String sendUnsortedEmail(){
        SendCustomersViaEmail.sendUnsortedEmail("rutkoski.augustus@heb.com", "rutkoski.augustus@heb.com", "Test Subject");
        return "redirect:/email";
    }


}
