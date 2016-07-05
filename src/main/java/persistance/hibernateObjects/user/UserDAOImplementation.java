package persistance.hibernateObjects.user;

import fileActions.CustomLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import util.HashPasswords;

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
        CustomLogger.createLogMsgAndSave("User updated successfully, Customer Details="+user.toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserEntity getUser(String userName, String password) {
        try{
            password = HashPasswords.hash(password);

            Session session = this.sessionFactory.getCurrentSession();

            java.util.List<UserEntity> user = (java.util.List<UserEntity>)
                    session.createQuery("from persistance.hibernateObjects.user.UserEntity where userName = :userName and password = :password")
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
