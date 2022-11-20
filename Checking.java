package com.dynamicBank;

public class Checking extends Account {
    String accountType = "checking";
    double initalDeposit;

    public Checking(double initalDeposit) {
        this.initalDeposit = initalDeposit;
        this.setBalance(initalDeposit);
        this.setInterst(3);
    }

    public String getAccountType() {
        return accountType;
    }
}
