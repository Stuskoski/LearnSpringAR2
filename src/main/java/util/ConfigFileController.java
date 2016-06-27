package util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by r730819 on 6/23/2016.
 */

@Controller
@Component
public class ConfigFileController {
    private static String databaseURL;
    private static String databaseUser;
    private static String databasePass;
    private static String mailHost;

    public static String getDatabaseURL() {
        return databaseURL;
    }

    public static String getDatabaseUser() {
        return databaseUser;
    }

    public static String getDatabasePass() {
        return databasePass;
    }

    public static String getMailHost() {
        return mailHost;
    }



    @Value("${db.url}")
    public void setDatabaseURL(String url){
        ConfigFileController.databaseURL = url;
    }
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




}
