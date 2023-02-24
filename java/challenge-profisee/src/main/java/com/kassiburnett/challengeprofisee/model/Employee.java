package com.kassiburnett.challengeprofisee.model;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private int idOfManager;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String town;
    private String state;
    private int zipCode;
    private int phone;
    private String emailAddress;
    private LocalDate startDate;
    private LocalDate terminationDate;

    public Employee(int employeeId, int idOfManager, String firstName, String lastName, String streetAddress,
                    String town, String state, int zipCode, int phone, String emailAddress, LocalDate startDate,
                    LocalDate terminationDate) {
        this.employeeId = employeeId;
        this.idOfManager = idOfManager;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.town = town;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.startDate = startDate;
        this.terminationDate = terminationDate;
    }

    public Employee(){}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getIdOfManager() {
        return idOfManager;
    }

    public void setIdOfManager(int idOfManager) {
        this.idOfManager = idOfManager;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }
}
