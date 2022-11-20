package com.dynamicBank;

public class Account {
    private double balance;
    private double interst;
    private int accountNumber;
    private static int NumberOfAccounts = 10_00_000;

    Account(){
        accountNumber = NumberOfAccounts++;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterst() {
        return interst;
    }

    public void setInterst(double interst) {
        this.interst = interst;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
