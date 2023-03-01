package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleDao {

    List<Sale> findAllSales();

    List<Sale> findSalesByDate(String startDate, String endDate);

    boolean createSale(Sale sale);
}
