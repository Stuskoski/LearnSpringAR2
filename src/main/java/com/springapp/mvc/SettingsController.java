package com.springapp.mvc;

import models.SettingsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.ConfigFileController;

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
    public String getSettingsPage(ModelMap modelMap, Model model){
        modelMap.addAttribute("dbURL", dbURL);
        modelMap.addAttribute("rootURL", rootURL);
        modelMap.addAttribute("dbUser", dbUser);
        modelMap.addAttribute("dbPass", dbPass);
        modelMap.addAttribute("mailHost", mailHost);

        model.addAttribute("settingsTemplate", new SettingsTemplate(ConfigFileController.getDatabaseURL(),
                ConfigFileController.getRootDatabaseURL(), ConfigFileController.getDatabaseUser(),
                ConfigFileController.getDatabasePass(), ConfigFileController.getMailHost()));

        return "settings";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changeSettings")
    public
    String changeSettings(@ModelAttribute("settingsTemplate") SettingsTemplate settingsTemplate){
        ConfigFileController.setDatabaseURLStatic(settingsTemplate.getDatabaseURL());
        ConfigFileController.setRootDatabaseURLStatic(settingsTemplate.getRootDatabaseURL());
        ConfigFileController.setDatabaseUserStatic(settingsTemplate.getDatabaseUser());
        ConfigFileController.setDatabasePassStatic(settingsTemplate.getDatabasePass());
        ConfigFileController.setMailHostStatic(settingsTemplate.getMailHost());

        return "redirect:/settings";
    }
}
