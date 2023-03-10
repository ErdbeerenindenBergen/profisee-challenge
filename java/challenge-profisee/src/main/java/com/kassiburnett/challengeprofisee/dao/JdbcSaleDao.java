package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductDao productDao;

    public JdbcSaleDao(JdbcTemplate jdbcTemplate, ProductDao productDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.productDao = productDao;
    }

    @Override
    public List<Sale> findAllSales() {
        String sql = "SELECT p.product_name, c.first_name, c.last_name, s.sale_id, s.sale_date, p.sale_price, " +
                "e.first_name, e.last_name, p.commission_percent " +
                "FROM sale s " +
                "JOIN product p ON s.product_id = p.product_id " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "JOIN employee e ON s.salesperson_id = e.employee_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return returnSaleInformation(results);
    }

    @Override
    public List<Sale> findSalesByDate(String startDate, String endDate) {
        LocalDate begin = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        String sql = "SELECT p.product_name, c.first_name, c.last_name, s.sale_id, s.sale_date, p.sale_price, " +
                " e.first_name, e.last_name, p.commission_percent " +
                "FROM sale s " +
                "JOIN product p ON s.product_id = p.product_id " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "JOIN employee e ON s.salesperson_id = e.employee_id " +
                "WHERE s.sale_date BETWEEN ? AND ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, begin, end);
        return returnSaleInformation(results);
    }

    @Override
    public boolean createSale(Sale sale) {
        String sql = "INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date) VALUES (?, ?, ?, ?);";
        int rowsInserted = jdbcTemplate.update(sql, sale.getProductId(), sale.getSalespersonId(), sale.getCustomerId(),
                sale.getSaleDate());
        if (rowsInserted != 1) {
            throw new RuntimeException("Failed to insert sale record.");
        }
        sql = "UPDATE product SET qty_on_hand = qty_on_hand - 1 WHERE product_id = ?;";
        int rowsUpdated = jdbcTemplate.update(sql, sale.getProductId());
        if (rowsUpdated != 1) {
            throw new RuntimeException("Failed to update product stock.");
        }
        return true;
    }

    public List<Sale> returnSaleInformation(SqlRowSet results) {
        List<Sale> sales = new ArrayList<>();
        while (results.next()) {
            String productName = results.getString(1);
            String customerFirstName = results.getString(2);
            String customerLastName = results.getString(3);
            Integer saleId = results.getInt(4);
            LocalDate saleDate = results.getDate(5).toLocalDate();
            BigDecimal salePrice = results.getBigDecimal(6);
            String salespersonFirstName = results.getString(7);
            String salespersonLastName = results.getString(8);
            BigDecimal commissionPercentage = results.getBigDecimal(9);
            BigDecimal salespersonCommission = salePrice.multiply(commissionPercentage);
            Sale sale = new Sale(productName, customerFirstName, customerLastName, saleId, saleDate, salePrice,
                    salespersonFirstName, salespersonLastName, commissionPercentage, salespersonCommission);
            sales.add(sale);
        }
        return sales;
    }

    private Sale mapRowToSale(SqlRowSet rs) {
        Sale sale = new Sale();
        sale.setSaleId(rs.getInt("sale_id"));
        sale.setProductId(rs.getInt("product_id"));
        sale.setSalespersonId(rs.getInt("salesperson_id"));
        sale.setCustomerId(rs.getInt("customer_id"));
        sale.setSaleDate(rs.getDate("sale_date").toLocalDate());
        return sale;
    }
}
