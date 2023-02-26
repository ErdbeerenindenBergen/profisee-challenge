package com.kassiburnett.challengeprofisee.controller;

import com.kassiburnett.challengeprofisee.dao.QuarterlyBonusDao;
import com.kassiburnett.challengeprofisee.model.CommissionReport;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/commissions")
public class QuarterlyBonusController {

    private final QuarterlyBonusDao quarterlyBonusDao;

    public QuarterlyBonusController(QuarterlyBonusDao quarterlyBonusDao) {
        this.quarterlyBonusDao = quarterlyBonusDao;
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{quarter}/{year}/{employeeId}", method = RequestMethod.GET)
    public CommissionReport getCommissionReport(@PathVariable("quarter") int quarter, @PathVariable("year") int year, @PathVariable("employeeId") int employeeId) {
        return quarterlyBonusDao.getQuarterlyCommissionReport(quarter, year, employeeId);
    }

}