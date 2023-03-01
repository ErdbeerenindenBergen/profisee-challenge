package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAllCustomers();

    Customer updateCustomer(Customer customer);

    boolean createCustomer(Customer customer);
}
