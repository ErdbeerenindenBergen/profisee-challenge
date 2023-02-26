package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.CommissionReport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class JdbcQuarterlyBonusDao implements QuarterlyBonusDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcQuarterlyBonusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CommissionReport getQuarterlyCommissionReport(int quarter, int year, int employeeId) {
        CommissionReport commissionReport = new CommissionReport();
        commissionReport.setEmployeeId(employeeId);
        commissionReport.setQuarter(quarter);
        commissionReport.setYear(year);
        LocalDate beginDate = null;
        LocalDate endDate = null;
        String yearString = Integer.toString(year);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        if (quarter == 1) {
            beginDate = LocalDate.parse("01/01/" + yearString, df);
            endDate = LocalDate.parse("03/31/" + yearString, df);
        }
        if (quarter == 2) {
            beginDate = LocalDate.parse("04/01/" + yearString);
            endDate = LocalDate.parse("06/30/" + yearString);
        }
        if (quarter == 3) {
            beginDate = LocalDate.parse("07/01/" + yearString);
            endDate = LocalDate.parse("09/30/" + yearString);
        }
        if (quarter == 4) {
            beginDate = LocalDate.parse("10/01/" + yearString);
            endDate = LocalDate.parse("12/31/" + yearString);
        }
        String sql = "SELECT e.first_name || ' ' || e.last_name AS salesperson_name, " +
                " ROUND(SUM(p.sale_price * p.commission_percent),2) AS commission " +
                " FROM sale s " + " JOIN product p ON s.product_id = p.product_id " +
                " JOIN employee e ON s.salesperson_id = e.employee_id " +
                " WHERE s.sale_date BETWEEN ? AND ? AND s.salesperson_id = ? " +
                " GROUP BY e.employee_id " + " ORDER BY commission DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beginDate, endDate, employeeId);
        while (results.next()) {
            commissionReport.setSalespersonName(results.getString(1));
            commissionReport.setCommission(results.getBigDecimal(2));
        }
        return commissionReport;
    }

    @Override
    public CommissionReport getAllCommissionReportsByQuarter(int quarter, int year, int employeeId) {
        CommissionReport commissionReport = new CommissionReport();
        commissionReport.setEmployeeId(employeeId);
        commissionReport.setQuarter(quarter);
        commissionReport.setYear(year);
        LocalDate beginDate = null;
        LocalDate endDate = null;
        String yearString = Integer.toString(year);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        if (quarter == 1) {
            beginDate = LocalDate.parse("01/01/" + yearString, df);
            endDate = LocalDate.parse("03/31/" + yearString, df);
        }
        if (quarter == 2) {
            beginDate = LocalDate.parse("04/01/" + yearString);
            endDate = LocalDate.parse("06/30/" + yearString);
        }
        if (quarter == 3) {
            beginDate = LocalDate.parse("07/01/" + yearString);
            endDate = LocalDate.parse("09/30/" + yearString);
        }
        if (quarter == 4) {
            beginDate = LocalDate.parse("10/01/" + yearString);
            endDate = LocalDate.parse("12/31/" + yearString);
        }
        String sql = "SELECT e.first_name || ' ' || e.last_name AS salesperson_name, " +
                " ROUND(SUM(p.sale_price * p.commission_percent),2) AS commission " +
                " FROM sale s " + " JOIN product p ON s.product_id = p.product_id " +
                " JOIN employee e ON s.salesperson_id = e.employee_id " +
                " WHERE s.sale_date BETWEEN ? AND ? AND s.salesperson_id = ? " +
                " GROUP BY e.employee_id " + " ORDER BY commission DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beginDate, endDate, employeeId);
        while (results.next()) {
            commissionReport.setSalespersonName(results.getString(1));
            commissionReport.setCommission(results.getBigDecimal(2));
        }
        return commissionReport;
    }
}
