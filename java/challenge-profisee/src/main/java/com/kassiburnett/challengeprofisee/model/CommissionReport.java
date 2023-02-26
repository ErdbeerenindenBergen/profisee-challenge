package com.kassiburnett.challengeprofisee.model;

import java.math.BigDecimal;

public class CommissionReport {
    private int employeeId;
    private String salespersonName;
    private BigDecimal totalCommission;
    private int quarter;
    private int year;

    CommissionReport report = new CommissionReport();

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public CommissionReport getReport() {
        return report;
    }

    public void setReport(CommissionReport report) {
        this.report = report;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
