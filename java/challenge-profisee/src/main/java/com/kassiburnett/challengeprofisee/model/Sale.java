package com.kassiburnett.challengeprofisee.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {
    private int saleId;
    private int productId;
    private int salespersonId;
    private int customerId;
    private LocalDate saleDate;
    private String productName;
    private String customerFirstName;
    private String customerLastName;
    private BigDecimal salePrice;
    private String salespersonFirstName;
    private String salespersonLastName;
    private BigDecimal commissionPercent;
    private BigDecimal salespersonCommission;

    public Sale(String productName, String customerFirstName, String customerLastName, LocalDate saleDate, BigDecimal salePrice, String salespersonFirstName, String salespersonLastName, BigDecimal commissionPercent, BigDecimal salespersonCommission) {
        this.saleDate = saleDate;
        this.productName = productName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.salePrice = salePrice;
        this.salespersonFirstName = salespersonFirstName;
        this.salespersonLastName = salespersonLastName;
        this.commissionPercent = commissionPercent;
        this.salespersonCommission = salespersonCommission;
    }

    public Sale(int saleId, int productId, int salespersonId, int customerId, LocalDate saleDate) {
        this.saleId = saleId;
        this.productId = productId;
        this.salespersonId = salespersonId;
        this.customerId = customerId;
        this.saleDate = saleDate;
    }

    public Sale(){}

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(int salespersonId) {
        this.salespersonId = salespersonId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
