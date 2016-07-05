package com.heb.assortment.service;

import com.heb.assortment.domain.DbCustomerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r730819 on 6/24/2016.
 *
 * The spring overlay for the customer DAO
 */
public interface CustomerSpringService {

    public void addCustomer(DbCustomerEntity p);
    public void addMultipleCustomers(ArrayList<DbCustomerEntity> customerList);
    public void updateCustomer(DbCustomerEntity p);
    public List<DbCustomerEntity> listCustomers();
    public DbCustomerEntity getCustomerById(int id);
    public void removeCustomer(int id);
}
