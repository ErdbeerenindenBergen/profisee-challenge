package com.kassiburnett.challengeprofisee.model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String name;
    private String manufacturer;
    private String style;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private int qtyOnHand;
    private BigDecimal commissionPercent;
    private long upcCode;

    public Product(int productId, String name, String manufacturer, String style, BigDecimal purchasePrice,
                   BigDecimal salePrice, int qtyOnHand, BigDecimal commissionPercent, int upcCode) {
        this.productId = productId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.style = style;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.qtyOnHand = qtyOnHand;
        this.commissionPercent = commissionPercent;
        this.upcCode = upcCode;
    }

    public Product(){}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public long getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(long upcCode) {
        this.upcCode = upcCode;
    }
}