package com.heb.assortment.core.models;

/**
 * Created by r730819 on 6/28/2016.
 *
 * Settings template that is used to
 * populate the settings jsp page.
 *
 * Is used also when sending the POST
 * request to alter the user settings.
 */
public class SettingsTemplate {
    private String databaseURL;
    private String rootDatabaseURL;
    private String databaseUser;
    private String databasePass;
    private String mailHost;
    private String mailFrom;

    //Constructors
    public SettingsTemplate(String databaseURL, String rootDatabaseURL, String databaseUser, String databasePass,
                            String mailHost, String mailFrom) {
        this.databaseURL = databaseURL;
        this.rootDatabaseURL = rootDatabaseURL;
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
        this.mailHost = mailHost;
        this.mailFrom = mailFrom;
    }
    public SettingsTemplate() {}


    //Getters and setters
    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getRootDatabaseURL() {
        return rootDatabaseURL;
    }

    public void setRootDatabaseURL(String rootDatabaseURL) {
        this.rootDatabaseURL = rootDatabaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePass() {
        return databasePass;
    }

    public void setDatabasePass(String databasePass) {
        this.databasePass = databasePass;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

}
