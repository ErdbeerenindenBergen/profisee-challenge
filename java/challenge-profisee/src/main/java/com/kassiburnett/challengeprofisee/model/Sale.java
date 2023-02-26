package com.kassiburnett.challengeprofisee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {

    @JsonIgnoreProperties(ignoreUnknown = true)

    private int saleId;
    private int productId;
    private int salespersonId;
    private int customerId;
    private LocalDate saleDate;
    private String productName;
    private String customerFirstName;
    private String customerLastName;
    private int customerPhoneNumber;
    private BigDecimal salePrice;
    private String salespersonFirstName;
    private String salespersonLastName;
    private BigDecimal commissionPercentage;
    private BigDecimal salespersonCommission;

    public Sale(String productName, String customerFirstName, String customerLastName, int saleId, LocalDate saleDate, BigDecimal salePrice, String salespersonFirstName, String salespersonLastName, BigDecimal commissionPercent, BigDecimal salespersonCommission) {
        this.productName = productName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.salespersonFirstName = salespersonFirstName;
        this.salespersonLastName = salespersonLastName;
        this.commissionPercentage = commissionPercent;
        this.salespersonCommission = salespersonCommission;
    }

    public Sale(int saleId, int productId, int salespersonId, int customerId, LocalDate saleDate) {
        this.saleId = saleId;
        this.productId = productId;
        this.salespersonId = salespersonId;
        this.customerId = customerId;
        this.saleDate = saleDate;
    }

    public Sale() {
    }

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalespersonFirstName() {
        return salespersonFirstName;
    }

    public void setSalespersonFirstName(String salespersonFirstName) {
        this.salespersonFirstName = salespersonFirstName;
    }

    public String getSalespersonLastName() {
        return salespersonLastName;
    }

    public void setSalespersonLastName(String salespersonLastName) {
        this.salespersonLastName = salespersonLastName;
    }

    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public BigDecimal getSalespersonCommission() {
        return salespersonCommission;
    }

    public void setSalespersonCommission(BigDecimal salespersonCommission) {
        this.salespersonCommission = salespersonCommission;
    }
}
