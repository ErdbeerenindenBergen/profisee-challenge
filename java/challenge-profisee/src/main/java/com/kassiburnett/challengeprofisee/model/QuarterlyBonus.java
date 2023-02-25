package com.kassiburnett.challengeprofisee.model;

import java.math.BigDecimal;

public class QuarterlyBonus {
    private int bonusId;
    private int salespersonId;
    private int bonusYear;
    private int quarter;
    private BigDecimal amount;
    private String salespersonFirstName;
    private String salespersonLastName;

    public QuarterlyBonus(int bonusId, int salespersonId, int bonusYear, int quarter, BigDecimal amount) {
        this.bonusId = bonusId;
        this.salespersonId = salespersonId;
        this.bonusYear = bonusYear;
        this.quarter = quarter;
        this.amount = amount;
    }

    public QuarterlyBonus(){}

    public int getBonusId() {
        return bonusId;
    }

    public void setBonusId(int bonusId) {
        this.bonusId = bonusId;
    }

    public int getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(int salespersonId) {
        this.salespersonId = salespersonId;
    }

    public int getBonusYear() {
        return bonusYear;
    }

    public void setBonusYear(int bonusYear) {
        this.bonusYear = bonusYear;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}
