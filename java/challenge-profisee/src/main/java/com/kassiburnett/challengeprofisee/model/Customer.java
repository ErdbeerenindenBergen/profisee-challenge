package com.kassiburnett.challengeprofisee.model;

import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String town;
    private String state;
    private int zipCode;
    private int phone;
    private String emailAddress;
    private LocalDate startDate;

    public Customer(int customerId, String firstName, String lastName, String streetAddress, String town,
                    String state, int zipCode, int phone, String emailAddress, LocalDate startDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.town = town;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.startDate = startDate;
    }
}
