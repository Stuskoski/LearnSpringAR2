package com.heb.assortment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by r730819 on 6/24/2016.
 *
 * Entity that represents the customers
 * table in the mysql database
 */

@Entity
@Table(name = "customers")
public class DbCustomerEntity {

    //Values
    @Id
    @Column(name = "idcustomers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;

    private String firstName;

    private String emailAddress;

    private String homeAddress;

    private String city;

    private String state;

    private String zipCode;

    private String timeStamp;

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        if(timeStamp!=null && timeStamp.length()>3){
            return timeStamp.substring(0, timeStamp.length()-2); //no idea why .0 is added at the end.  Substring it off
        }else{
            return "";
        }
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public String toString(){
        String customerString = "";
        StringBuilder stringBuilder = new StringBuilder(customerString);

        stringBuilder.append("Customer #").append(id).append("\n");
        stringBuilder.append(lastName).append(", ").append(firstName).append("\n");
        stringBuilder.append(emailAddress).append("\n");
        stringBuilder.append(homeAddress).append("\n");
        stringBuilder.append(city).append(" ").append(state).append(" ").append(zipCode).append("\n");
        if(timeStamp!=null && !timeStamp.equals("")){
            stringBuilder.append(timeStamp);
        }
        stringBuilder.append("\n\n");

        return stringBuilder.toString();
    }


}
