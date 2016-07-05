package com.heb.assortment.service.impl;

import com.heb.assortment.persistance.CustomerDAO;
import com.heb.assortment.service.CustomerSpringService;
import org.springframework.transaction.annotation.Transactional;
import com.heb.assortment.domain.DbCustomerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r730819 on 6/24/2016.
 *
 * The Spring implementation overlay for Customer DAO
 */
public class CustomerSpringServiceImplementation implements CustomerSpringService {

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void addCustomer(DbCustomerEntity customer) {
        this.customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public void addMultipleCustomers(ArrayList<DbCustomerEntity> customerList) {
        for(DbCustomerEntity customer : customerList){
            this.customerDAO.addCustomer(customer);
        }
    }

    @Override
    @Transactional
    public void updateCustomer(DbCustomerEntity customer) {
        this.customerDAO.updateCustomer(customer);
    }

    @Override
    @Transactional
    public List<DbCustomerEntity> listCustomers() {
        return this.customerDAO.listCustomers();
    }

    @Override
    @Transactional
    public DbCustomerEntity getCustomerById(int id) {
        return this.customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void removeCustomer(int id) {
        this.customerDAO.removeCustomer(id);
    }
}
