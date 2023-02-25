package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Employee;
import com.kassiburnett.challengeprofisee.model.QuarterlyBonus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcSalespersonDao implements SalespersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSalespersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public boolean updateSalesperson(Employee employee) {
        return false;
    }

    @Override
    public Employee findSalespersonById(Integer id) {
        return null;
    }

    @Override
    public List<QuarterlyBonus> displaySalesReport() {
        return null;
    }
}
