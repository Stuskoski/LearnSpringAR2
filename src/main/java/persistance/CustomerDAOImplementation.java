package persistance;

import fileActions.CustomLogger;
import models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by r730819 on 6/24/2016.
 */

@Repository
public class CustomerDAOImplementation implements CustomerDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addCustomer(DbCustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        CustomLogger.createLogMsgAndSave("Customer saved successfully, Customer Details="+customer.toString());
    }

    @Override
    public void updateCustomer(DbCustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        CustomLogger.createLogMsgAndSave("Customer updated successfully, Customer Details="+customer.toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DbCustomerEntity> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
       // String qry = "FROM " + "customers";
        List<DbCustomerEntity> customerList = (List<DbCustomerEntity>)session.createQuery("from persistance.DbCustomerEntity").list();
        for (DbCustomerEntity customer : customerList){
            CustomLogger.createLogMsgAndSave("Customer Info: \n"+customer.toString());
        }
        return customerList;
    }

    @Override
    public DbCustomerEntity getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DbCustomerEntity customer = (DbCustomerEntity) session.load(DbCustomerEntity.class, new Integer(id));
        CustomLogger.createLogMsgAndSave("Customer loaded successfully, Customer details = " + customer.toString());
        return customer;
    }

    @Override
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DbCustomerEntity customer = (DbCustomerEntity) session.load(DbCustomerEntity.class, new Integer(id));
        if(customer != null){
            session.delete(customer);
        }
        CustomLogger.createLogMsgAndSave("Customer deleted successfully, customer details = " + (customer != null ? customer.toString() : null));
    }
}
