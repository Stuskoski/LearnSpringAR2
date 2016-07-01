package models;

/**
 * Created by r730819 on 6/30/2016.
 */
public class StatsModel {
    private int dbEntries;
    private int numberOfTexans;
    private int numberOfNonTexans;
    private int numberOfUsers;
    private int numberOfLogs;
    private String lastEmail;
    private String lastCustomerUpdate;

    public int getDbEntries() {
        return dbEntries;
    }

    public void setDbEntries(int dbEntries) {
        this.dbEntries = dbEntries;
    }

    public int getNumberOfTexans() {
        return numberOfTexans;
    }

    public void setNumberOfTexans(int numberOfTexans) {
        this.numberOfTexans = numberOfTexans;
    }

    public int getNumberOfNonTexans() {
        return numberOfNonTexans;
    }

    public void setNumberOfNonTexans(int numberOfNonTexans) {
        this.numberOfNonTexans = numberOfNonTexans;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getNumberOfLogs() {
        return numberOfLogs;
    }

    public void setNumberOfLogs(int numberOfLogs) {
        this.numberOfLogs = numberOfLogs;
    }

    public String getLastEmail() {
        if(lastEmail!=null && lastEmail.length()>3){
            return lastEmail.substring(0, lastEmail.length()-2); //no idea why .0 is added at the end.  Substring it off
        }else{
            return "";
        }

    }

    public void setLastEmail(String lastEmail) {
        this.lastEmail = lastEmail;
    }

    public String getLastCustomerUpdate() {
        if(lastCustomerUpdate!=null && lastCustomerUpdate.length()>3){
            return lastCustomerUpdate.substring(0, lastCustomerUpdate.length()-2); //no idea why .0 is added at the end.  Substring it off
        }else{
            return "";
        }
    }

    public void setLastCustomerUpdate(String lastCustomerUpdate) {
        this.lastCustomerUpdate = lastCustomerUpdate;
    }




}