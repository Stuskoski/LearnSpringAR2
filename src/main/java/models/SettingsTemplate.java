package models;

/**
 * Created by r730819 on 6/28/2016.
 */
public class SettingsTemplate {
    private String databaseURL;
    private String rootDatabaseURL;
    private String databaseUser;
    private String databasePass;
    private String mailHost;

    public SettingsTemplate(String databaseURL, String rootDatabaseURL, String databaseUser, String databasePass,
                            String mailHost) {
        this.databaseURL = databaseURL;
        this.rootDatabaseURL = rootDatabaseURL;
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
        this.mailHost = mailHost;
    }
    public SettingsTemplate() {
    }


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

}