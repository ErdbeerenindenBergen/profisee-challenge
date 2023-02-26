package com.kassiburnett.challengeprofisee.controller;

import com.kassiburnett.challengeprofisee.dao.SalespersonDao;
import com.kassiburnett.challengeprofisee.model.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/salespersons")
public class SalespersonController {

    private final SalespersonDao salespersonDao;

    public SalespersonController(SalespersonDao salespersonDao) {
        this.salespersonDao = salespersonDao;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Employee> getAllSalespersons() {
        return salespersonDao.findAll();
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Employee updateSalesperson(@RequestBody Employee employee) {
        return salespersonDao.updateSalesperson(employee);
    }
}
