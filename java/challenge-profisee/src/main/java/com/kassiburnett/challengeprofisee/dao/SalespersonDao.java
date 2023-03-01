package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Employee;

import java.util.List;

public interface SalespersonDao {

    List<Employee> findAll();

    Employee updateSalesperson(Employee employee);

    boolean createSalesperson(Employee employee);
}
