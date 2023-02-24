package com.kassiburnett.challengeprofisee.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Discount {
    private int discountId;
    private int productId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private BigDecimal discountPercentage;

    public Discount(int discountId, int productId, LocalDate beginDate, LocalDate endDate,
                    BigDecimal discountPercentage) {
        this.discountId = discountId;
        this.productId = productId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
