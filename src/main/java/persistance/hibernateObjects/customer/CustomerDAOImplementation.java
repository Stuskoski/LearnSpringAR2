package persistance.hibernateObjects.customer;

import fileActions.CustomLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r730819 on 6/24/2016.
 * The actual customer DAO implementation
 */

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    /**
     * Add the customer to the database
     * @param customer Entity to be added to DB
     */
    @Override
    public void addCustomer(DbCustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        //CustomLogger.createLogMsgAndSave("Customer saved successfully, Customer Details="+customer.toString());
    }

    /**
     * Add multiple customers.
     *
     * @param customerList An arrarylist of entities to be added to DB
     */
    @Override
    public void addMultipleCustomers(ArrayList<DbCustomerEntity> customerList) {
        Session session = this.sessionFactory.getCurrentSession();

        for(DbCustomerEntity customer : customerList){
            session.persist(customer);
            CustomLogger.createLogMsgAndSave("Customer saved successfully, Customer Details="+customer.toString());
        }
    }

    /**
     * Update the customer in the database with the new entity
     *
     * @param customer Entity to be updated
     */
    @Override
    public void updateCustomer(DbCustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        CustomLogger.createLogMsgAndSave("Customer updated successfully, Customer Details="+customer.toString());
    }

    /**
     * Grab all the customers from the database and put them in
     * a list object
     *
     * @return List of all customers
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DbCustomerEntity> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        //Line below does not change on refactor.  Remember this
        List<DbCustomerEntity> customerList = (List<DbCustomerEntity>)
                session.createQuery("from persistance.hibernateObjects.customer.DbCustomerEntity").list();
        if(customerList.size() <= 500){
            CustomLogger.createLogMsgAndSave("Reading Customers");
            for (DbCustomerEntity customer : customerList){
                 CustomLogger.createLogMsgAndSave("Customer Info: \n"+customer.toString());
            }
        }else{
            CustomLogger.createLogErrorAndSave("Customer list too large to list all customers. 500 or less.");
        }

        return customerList;
    }

    /**
     * Get the customer from the database
     * according to their ID
     *
     * @param id Customer ID
     * @return The entity retrieved from DB
     */
    @Override
    public DbCustomerEntity getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DbCustomerEntity customer = (DbCustomerEntity) session.load(DbCustomerEntity.class, new Integer(id));
        CustomLogger.createLogMsgAndSave("Customer loaded successfully, Customer details = " + customer.toString());
        return customer;
    }

    /**
     * Remove the customer according to their ID
     *
     * @param id The customers ID to identify which one to delete
     */
    @Override
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DbCustomerEntity customer = (DbCustomerEntity) session.load(DbCustomerEntity.class, new Integer(id));
        if(customer != null){
            CustomLogger.createLogMsgAndSave("Customer deleted successfully, customer details: "+customer.toString());
            session.delete(customer);
        }
    }
}
