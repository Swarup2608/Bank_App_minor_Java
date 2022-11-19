package com.bankApp;

public class Account {
    private String name;
    private  String email;
    private double balance;
    private  String account_no;
    private  String phone_no;
    private String account_pin;

    public Account(String name, String email, double balance, String account_no, String phone_no,String account_pin) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.account_no = account_no;
        this.phone_no = phone_no;
        this.account_pin = account_pin;
    }

    public void depositMoney(double depositAmount){
        this.balance +=depositAmount;
        System.out.println("Deposit scuccessfull, Remaining balance : "+this.balance);
    }

    public void withdrawMoney(double withdrawAmount){
         double balance1 = this.balance;
         if(balance1 - withdrawAmount >= 0){
             this.balance-=withdrawAmount;
             System.out.println("Withdraw scuccessfull, Remaining balance : "+this.balance);
         }else{
             System.out.println("Withdraw unscuccessfull due to lack of insufficient funds");
         }
    }

    public void viewDetails(){
        System.out.println("-".repeat(40));
        printtName();
        printAccount_no();
        printEmail();
        printPhone_no();
        printBalance();
        System.out.println("-".repeat(40));
    }

    public void printtName() {
        System.out.println("Name : "+this.name);
    }

    public void printEmail() {
        System.out.println("Email : "+this.email);
    }

    public void printBalance() {
        System.out.println("Balance : "+this.balance);
    }

    public void printAccount_no() {
        System.out.println("Account Number : "+this.account_no);
    }

    public void printPhone_no() {
        System.out.println("Phone Number : "+this.phone_no);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getPhone_no() {
        return phone_no;
    }
}
