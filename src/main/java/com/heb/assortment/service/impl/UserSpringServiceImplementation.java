package com.heb.assortment.service.impl;

import com.heb.assortment.domain.UserEntity;
import com.heb.assortment.persistance.UserDAO;
import com.heb.assortment.service.UserSpringService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by r730819 on 6/29/2016.
 *
 * The actual spring implementation overlay for user DAO and hibernate
 *
 * Just calls the actual functions in UserDAOImplementation
 */
public class UserSpringServiceImplementation implements UserSpringService {

    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){ this.userDAO = userDAO; }

    @Override
    @Transactional
    public void addUser(UserEntity user) {
        this.userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        this.userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public UserEntity getUser(String userName, String password) {
        return this.userDAO.getUser(userName, password);
    }

    @Override
    @Transactional
    public void removeUser(String userName, String password) {
        this.userDAO.removeUser(userName, password);
    }
}
