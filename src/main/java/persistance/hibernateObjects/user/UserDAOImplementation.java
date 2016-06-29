package persistance.hibernateObjects.user;

import fileActions.CustomLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by r730819 on 6/29/2016.
 */
@Repository
public class UserDAOImplementation implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        CustomLogger.createLogMsgAndSave("User saved successfully, Customer Details=" + user.toString());
    }

    @Override
    public void updateUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        CustomLogger.createLogMsgAndSave("Customer updated successfully, Customer Details="+user.toString());
    }

    @Override
    public UserEntity getUser(String userName, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity user = (UserEntity) session.load(UserEntity.class, userName);
        CustomLogger.createLogMsgAndSave("Customer loaded successfully, Customer details = " + user.toString());
        return user;
    }

    @Override
    public void removeUser(String userName, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity user = (UserEntity) session.load(UserEntity.class, userName);
        if(user != null){
            CustomLogger.createLogMsgAndSave("Customer deleted successfully, customer details: "+user.toString());
            session.delete(user);
        }
    }
}
