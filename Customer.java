package com.dynamicBank;

public class Customer {
    String name;
    String ssn;
    Account account;

    public Customer(String name, String ssn, Account account) {
        this.name = name;
        this.ssn = ssn;
        this.account = account;
    }
}
