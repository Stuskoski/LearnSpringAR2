package com.heb.assortment.core.controllers;

import com.heb.assortment.util.fileActions.CustomLogger;
import com.heb.assortment.core.models.SettingsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by r730819 on 6/22/2016.
 *
 * Settings controller class that will
 * originally be initialized to the variables
 * from the config file.
 *
 * Since those values from the config file are
 * instantiated at server reboot, a static
 * reference is needed.
 *
 * If the user changes the values via the settings
 * page the static values will be used until a server
 * reboot puts them back to default values.
 *
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
    @Value("${mail.mailFrom}")
    private String mailFrom;


    /**
     * GET request for the settings page
     *
     * @param model Model to preload the page with values
     * @param request Check for user session
     * @return Either view the page or redirect to
     *         login page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getSettingsPage(Model model, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){

            model.addAttribute("settingsTemplate", new SettingsTemplate(ConfigFileController.getDatabaseURL(),
                    ConfigFileController.getRootDatabaseURL(), ConfigFileController.getDatabaseUser(),
                    ConfigFileController.getDatabasePass(), ConfigFileController.getMailHost(),
                    ConfigFileController.getMailFrom()));

            return "settings";
        }else{
            return "redirect:/login";
        }
    }

    /**
     * POST request to the changeSettings URL
     * that will take the settings form and
     * set static values to the new forms
     *
     * @param settingsTemplate Form that contains new settings value
     * @param request Check for user session
     * @return Settings page view or redirect to login
     */
    @RequestMapping(method = RequestMethod.POST, value = "/changeSettings")
    public String changeSettings(@ModelAttribute("settingsTemplate") SettingsTemplate settingsTemplate,
                                 HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            CustomLogger.createLogMsgAndSave("Updating settings");

            ConfigFileController.setDatabaseURLStatic(settingsTemplate.getDatabaseURL());
            ConfigFileController.setRootDatabaseURLStatic(settingsTemplate.getRootDatabaseURL());
            ConfigFileController.setDatabaseUserStatic(settingsTemplate.getDatabaseUser());
            ConfigFileController.setDatabasePassStatic(settingsTemplate.getDatabasePass());
            ConfigFileController.setMailHostStatic(settingsTemplate.getMailHost());
            ConfigFileController.setMailFromStatic(settingsTemplate.getMailFrom());

            CustomLogger.createLogMsgAndSave("Settings updated");

            return "settings";
        }else{
            return "redirect:/login";
        }


    }
}
