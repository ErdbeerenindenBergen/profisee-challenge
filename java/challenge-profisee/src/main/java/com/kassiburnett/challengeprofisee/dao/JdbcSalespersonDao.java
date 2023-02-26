package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Employee;
import com.kassiburnett.challengeprofisee.model.QuarterlyBonus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSalespersonDao implements SalespersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSalespersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT e.employee_id, e.id_of_manager, e.first_name, e.last_name, \n" + " e.street_address, e.town, e.employee_state, e.zip_code, e.phone, e.email_address, \n" + " e.start_date, e.termination_date, m.first_name AS manager_first_name, \n" + " m.last_name AS manager_last_name \n" + " FROM employee e LEFT JOIN employee m ON e.id_of_manager = m.employee_id ORDER BY employee_id ASC ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Employee> salespersons = new ArrayList<>();
        while (results.next()) {
            Employee employee = mapRowToEmployee(results);
            salespersons.add(employee);
        }
        return salespersons;
    }

    @Override
    public Employee updateSalesperson(Employee employee) {
        String sql = "UPDATE employee SET id_of_manager = ?, first_name = ?, last_name = ?, " + " street_address = ?, town = ?, employee_state = ?, zip_code = ?, phone = ?, " + " email_address = ?, start_date = ?, termination_date = ? " + " WHERE employee_id = ?;";
        jdbcTemplate.update(sql, employee.getIdOfManager(), employee.getFirstName(), employee.getLastName(), employee.getStreetAddress(), employee.getTown(), employee.getState(), employee.getZipCode(), employee.getPhone(), employee.getEmailAddress(), employee.getStartDate(), employee.getTerminationDate(), employee.getEmployeeId());
        return employee;
    }

    @Override
    public List<QuarterlyBonus> displaySalesReport() {
        return null;
    }

    private Employee mapRowToEmployee(SqlRowSet rs) {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("employee_id"));
        employee.setIdOfManager(rs.getInt("id_of_manager"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setStreetAddress(rs.getString("street_address"));
        employee.setTown(rs.getString("town"));
        employee.setState(rs.getString("employee_state"));
        employee.setZipCode(rs.getInt("zip_code"));
        employee.setPhone(rs.getLong("phone"));
        employee.setEmailAddress(rs.getString("email_address"));
        employee.setStartDate(rs.getDate("start_date").toLocalDate());
        if (rs.getDate("termination_date") != null) {
            employee.setTerminationDate(rs.getDate("termination_date").toLocalDate());
        }
        employee.setManagerFirstName(rs.getString("manager_first_name"));
        employee.setManagerLastName(rs.getString("manager_last_name"));
        return employee;
    }
}
