package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Employee;
import com.kassiburnett.challengeprofisee.model.QuarterlyBonus;

import java.util.List;

public interface SalespersonDao {

    //Displays a list of Salespersons
    List<Employee> findAll();

    //Update Salesperson
    Employee updateSalesperson(Employee employee);

    //display quarterly sales report
    List<QuarterlyBonus> displaySalesReport();
}
