package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.CommissionReport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JdbcQuarterlyBonusDao implements QuarterlyBonusDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcQuarterlyBonusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CommissionReport getQuarterlyCommissionReport(int quarter, int year, int employeeId) {
        LocalDate beginDate = null;
        LocalDate endDate = null;
        if (quarter == 1) {
            beginDate = LocalDate.parse("01-01-" + year);
            endDate = LocalDate.parse("03-31-" + year);
        }
        if (quarter == 2) {
            beginDate = LocalDate.parse("04-01-" + year);
            endDate = LocalDate.parse("06-30-" + year);
        }
        if (quarter == 3) {
            beginDate = LocalDate.parse("07-01-" + year);
            endDate = LocalDate.parse("09-30-" + year);
        }
        if (quarter == 4) {
            beginDate = LocalDate.parse("10-01-" + year);
            endDate = LocalDate.parse("12-31-" + year);
        }
        String sql = "SELECT e.first_name || ' ' || e.last_name AS salesperson_name, \n" + " ROUND(SUM(p.sale_price * p.commission_percent),2) AS commission \n" + " FROM sale s \n" + " JOIN product p ON s.product_id = p.product_id \n" + " JOIN employee e ON s.salesperson_id = e.employee_id \n" + " WHERE s.sale_date BETWEEN ? AND ? AND s.salesperson_id = ? \n" + " GROUP BY e.employee_id \n" + " ORDER BY commission DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beginDate, endDate, employeeId);

        if (results.next()) {
            CommissionReport commissionReport = new CommissionReport();
            commissionReport.setQuarter(quarter);
            commissionReport.setEmployeeId(employeeId);
            commissionReport.setYear(year);
            commissionReport.setSalespersonName(results.getString("salesperson_name"));
            commissionReport.setTotalCommission(results.getBigDecimal("commission"));
            return commissionReport;
        } else {
            return null;
        }
    }
}
