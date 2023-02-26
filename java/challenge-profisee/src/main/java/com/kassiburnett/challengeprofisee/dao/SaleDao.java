package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleDao {

    //displays a list of sales, optional filter by date range, should include product,
    //customer, date, price, salesperson, salesperson commission
    List<Sale> findAllSales();

    //searches for sales by date-range
    List<Sale> findSalesByDate(String startDate, String endDate);

    //creates a sale in the database
    boolean createSale(Sale sale);
}
