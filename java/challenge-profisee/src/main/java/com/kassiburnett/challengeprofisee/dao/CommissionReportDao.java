package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.CommissionReport;

import java.util.List;

public interface CommissionReportDao {

    CommissionReport getQuarterlyCommissionReport(int quarter, int year, int employeeId);

    List<CommissionReport> getAllCommissionReportsByQuarter(int quarter, int year);
}
