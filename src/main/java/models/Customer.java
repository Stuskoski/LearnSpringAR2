package models;

/**
 * A person object that is created
 * in FileActions.ReadFile.  All details
 * must be present for object to be created.
 *
 * These person objects are stored in a
 * static array list contained in
 * PeopleModels.CustomerArrayList which
 * is populated in FileActions.ReadFile.
 *
 * todo set private access with getters/setters
 *
 * Created by r730819 on 6/15/2016.
 */
public class Customer {
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String homeAddress;
    private String city;
    private String state;
    private String zipCode;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    private String timeStamp;
    private int customerNum;


}
