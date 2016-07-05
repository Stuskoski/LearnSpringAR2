package com.heb.assortment.core.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by r730819 on 6/23/2016.
 *
 * Config file controller that handles
 * all the configuration/settings for the server.
 *
 * originally autowired with the values from
 * the config file but holds static references to
 * have the ability to alter them.
 *
 * Back to default config file properties on server
 * reboot
 */

@Controller
@Component
public class ConfigFileController {
    //Private values initialized with autowiring
    private static String databaseURL;
    private static String rootDatabaseURL;
    private static String databaseUser;
    private static String databasePass;
    private static String mailHost;
    private static String mailFrom;

    //Static references to those values
    public static String getDatabaseURL() {
        return databaseURL;
    }
    public static String getRootDatabaseURL(){ return  rootDatabaseURL; }
    public static String getDatabaseUser() {
        return databaseUser;
    }
    public static String getDatabasePass() {
        return databasePass;
    }
    public static String getMailHost() {
        return mailHost;
    }
    public static String getMailFrom() {
        return mailFrom;
    }

    //Autowiring
    @Value("${db.url}")
    public void setDatabaseURL(String url){
        ConfigFileController.databaseURL = url;
    }
    @Value("${db.rootUrl}")
    public void setRootDatabaseURL(String rootURL) { ConfigFileController.rootDatabaseURL = rootURL; }
    @Value("${db.user}")
    public void setDatabaseUser(String user){
        ConfigFileController.databaseUser = user;
    }
    @Value("${db.pass}")
    public void setDatabasePass(String pass){
        ConfigFileController.databasePass = pass;
    }
    @Value("${mail.host}")
    public void setMailHost(String host){
        ConfigFileController.mailHost = host;
    }
    @Value(("${mail.mailFrom}"))
    public void setMailFrom(String email){
        ConfigFileController.mailFrom = email;
    }

    //Temporary file changes here till server reboot
    public static void setDatabaseURLStatic(String url){
        ConfigFileController.databaseURL = url;
    }
    public static void setRootDatabaseURLStatic(String rootURL) { ConfigFileController.rootDatabaseURL = rootURL; }
    public static void setDatabaseUserStatic(String user){
        ConfigFileController.databaseUser = user;
    }
    public static void setDatabasePassStatic(String pass){
        ConfigFileController.databasePass = pass;
    }
    public static void setMailHostStatic(String host){ ConfigFileController.mailHost = host; }
    public static void setMailFromStatic(String email){
        ConfigFileController.mailFrom = email;
    }

}
