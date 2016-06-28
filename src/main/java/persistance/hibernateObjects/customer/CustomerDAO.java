package persistance.hibernateObjects.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r730819 on 6/24/2016.
 */
public interface CustomerDAO {

    public void addCustomer(DbCustomerEntity customer);
    public void addMultipleCustomers(ArrayList<DbCustomerEntity> customerList);
    public void updateCustomer(DbCustomerEntity customer);
    public List<DbCustomerEntity> listCustomers();
    public DbCustomerEntity getCustomerById(int id);
    public void removeCustomer(int id);
}
