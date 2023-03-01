package com.kassiburnett.challengeprofisee.controller;

import com.kassiburnett.challengeprofisee.dao.CommissionReportDao;
import com.kassiburnett.challengeprofisee.model.CommissionReport;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/commissions")
public class CommissionReportController {

    private final CommissionReportDao commissionReportDao;

    public CommissionReportController(CommissionReportDao commissionReportDao) {
        this.commissionReportDao = commissionReportDao;
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{quarter}/{year}/{employeeId}", method = RequestMethod.GET)
    public CommissionReport getCommissionReportByQuarterAndEmployee(@PathVariable("quarter") int quarter,
                                                                    @PathVariable("year") int year,
                                                                    @PathVariable("employeeId") int employeeId) {
        return commissionReportDao.getQuarterlyCommissionReport(quarter, year, employeeId);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{quarter}/{year}", method = RequestMethod.GET)
    public List<CommissionReport> getAllCommissionReportsByQuarter(@PathVariable("quarter") int quarter,
                                                                   @PathVariable("year") int year) {
        return commissionReportDao.getAllCommissionReportsByQuarter(quarter, year);
    }

}