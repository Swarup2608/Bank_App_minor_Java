package com.dynamicBank;

public class Saving extends Account{
    String accountType = "saving";
    double initalDeposit;

    public Saving(double initalDeposit) {
        this.initalDeposit = initalDeposit;
        this.setBalance(initalDeposit);
        this.setInterst(2);
    }

    public String getAccountType() {
        return accountType;
    }
}
