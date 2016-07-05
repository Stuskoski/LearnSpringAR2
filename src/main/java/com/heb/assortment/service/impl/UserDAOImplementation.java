package com.heb.assortment.service.impl;

import com.heb.assortment.domain.UserEntity;
import com.heb.assortment.persistance.UserDAO;
import com.heb.assortment.util.fileActions.CustomLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.heb.assortment.util.login.HashPasswords;

/**
 * Created by r730819 on 6/29/2016.
 *
 * The implementation of the user DAO for hibernate.
 */
@Repository
public class UserDAOImplementation implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Add the user to the database.  Not currently used b/c I manually add users.
     *
     * Originally planned for a signup like page
     *
     * @param user User object to be added to database
     */
    @Override
    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        CustomLogger.createLogMsgAndSave("User saved successfully, Customer Details=" + user.toString());
    }

    /**
     * Method update the user in the database with
     * the new user object
     *
     * Not currently used
     *
     * @param user User object to be updated
     */
    @Override
    public void updateUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        CustomLogger.createLogMsgAndSave("User updated successfully, Customer Details="+user.toString());
    }

    /**
     * Get the user from the database with
     * the passed credentials.
     *
     * Hashes the password before checking
     * to make sure the hash matches the one
     * in the database.
     *
     * @param userName Credential
     * @param password Credential
     * @return User Entity if it exists
     */
    @SuppressWarnings("unchecked")
    @Override
    public UserEntity getUser(String userName, String password) {
        try{
            password = HashPasswords.hash(password);

            Session session = this.sessionFactory.getCurrentSession();

            java.util.List<UserEntity> user = (java.util.List<UserEntity>)
                    session.createQuery("from com.heb.assortment.domain.UserEntity where userName = :userName and password = :password")
                            .setParameter("userName", userName)
                            .setParameter("password", password)
                            .list();

            CustomLogger.createLogMsgAndSave("User loaded successfully, Customer details = " + user.toString());

            return user.get(0);
        }catch (Exception e){
            CustomLogger.createLogMsgAndSave("Something went wrong trying to pull user. " +e.getMessage());
            return null;
        }



    }

    /**
     * Method to remove the user from the database with
     * the appropriate credentials
     *
     * Not currently used
     *
     * @param userName Credential
     * @param password Credential
     */
    @Override
    public void removeUser(String userName, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity user = (UserEntity) session.load(UserEntity.class, userName);
        if(user != null){
            CustomLogger.createLogMsgAndSave("User deleted successfully, customer details: "+user.toString());
            session.delete(user);
        }
    }
}
