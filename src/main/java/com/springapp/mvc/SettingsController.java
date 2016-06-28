package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.ConfigFileController;

import java.lang.reflect.Method;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/settings")
public class SettingsController {
    @Value("${db.url}")
    private String dbURL;
    @Value("${db.rootUrl}")
    private String rootURL;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.pass}")
    private String dbPass;
    @Value("${mail.host}")
    private String mailHost;


    @RequestMapping(method = RequestMethod.GET)
    public String getSettingsPage(ModelMap modelMap){
        modelMap.addAttribute("dbURL", dbURL);
        modelMap.addAttribute("rootURL", rootURL);
        modelMap.addAttribute("dbUser", dbUser);
        modelMap.addAttribute("dbPass", dbPass);
        modelMap.addAttribute("mailHost", mailHost);
        return "settings";
    }
}
