package com.kassiburnett.challengeprofisee.controller;

import com.kassiburnett.challengeprofisee.dao.SaleDao;
import com.kassiburnett.challengeprofisee.model.Sale;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/sales")
public class SaleController {

    private final SaleDao saleDao;

    public SaleController(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Sale> getAllSales() {
        return saleDao.findAllSales();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{startDate}/{endDate}", method = RequestMethod.GET)
    public List<Sale> getSalesByDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
        return saleDao.findSalesByDate(startDate, endDate);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public boolean createNewSale(@RequestBody Sale sale) {
        return saleDao.createSale(sale);
    }
}
