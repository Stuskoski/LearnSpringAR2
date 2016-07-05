package com.heb.assortment.persistance;

import com.heb.assortment.domain.UserEntity;

/**
 * Created by r730819 on 6/29/2016.
 *
 * Interface for the user DAO for hibernate transactions
 * Typical user alteration methods
 */
public interface UserDAO {

    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public UserEntity getUser(String userName, String password);
    public void removeUser(String userName, String password);
}
