package com.kassiburnett.challengeprofisee.model;

import java.time.LocalDate;

public class Sale {
    private int saleId;
    private int productId;
    private int salespersonId;
    private int customerId;
    private LocalDate saleDate;

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
