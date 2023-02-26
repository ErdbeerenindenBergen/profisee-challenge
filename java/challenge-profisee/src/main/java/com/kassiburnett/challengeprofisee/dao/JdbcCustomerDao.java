package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Customer;
import com.kassiburnett.challengeprofisee.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAllCustomers() {
        String sql = "SELECT * FROM customer ORDER BY customer_id ASC ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Customer> customers = new ArrayList<>();
        while (results.next()) {
            Customer customer = mapRowToCustomer(results);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET " + "first_name = ?, " + "last_name = ?, " + "street_address = ?, " + "town = ?, " + "customer_state = ?, " + "zip_code = ?, " + "phone = ?, " + "email_address = ?, " + "start_date = ? " + "WHERE customer_id = ?;";

        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getStreetAddress(), customer.getTown(), customer.getState(), customer.getZipCode(), customer.getPhone(), customer.getEmailAddress(), customer.getStartDate(), customer.getCustomerId());
        return customer;
    }

    private Customer mapRowToCustomer(SqlRowSet results) {
        Customer customer = new Customer();
        customer.setCustomerId(results.getInt("customer_id"));
        customer.setFirstName(results.getString("first_name"));
        customer.setLastName(results.getString("last_name"));
        customer.setStreetAddress(results.getString("street_address"));
        customer.setTown(results.getString("town"));
        customer.setState(results.getString("customer_state"));
        customer.setZipCode(results.getInt("zip_code"));
        customer.setPhone(results.getLong("phone"));
        customer.setEmailAddress(results.getString("email_address"));
        customer.setStartDate(results.getDate("start_date").toLocalDate());
        return customer;
    }

}
