package com.heb.assortment.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity object that represents
 * users that are able to log in to the
 * webpage
 */
@Entity
@Table(name = "users")
public class UserEntity {

    //Values
    @Id
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    private String password;

    //getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Username: \"" + userName + "\"";
    }

}
