package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Customer;

import java.util.List;

public interface CustomerDao {

    //displays a list of customers
    List<Customer> findAllCustomers();

    Customer updateCustomer(Customer customer);

    boolean createCustomer(Customer customer);
}
