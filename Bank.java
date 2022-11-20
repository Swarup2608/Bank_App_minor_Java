package com.dynamicBank;

import java.util.LinkedList;

public class Bank {
    String bankName;
    LinkedList<Customer> customers  = new LinkedList<Customer>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(Customer customer){
        int f = 0;
        for(Customer CheckQ : customers){
            if(CheckQ.name.equals(customer.name)){
                f = 1;
                break;
            }
        }
        if(f == 0){
            customers.add(customer);
            System.out.println("Customer Successfully added");
        }
        else{
            System.out.println("Customer Already Exists");
        }
    }

    public  Customer checkValidation(int acc_no,String ssn){
        for(Customer checkq : customers){
            if(checkq.account.getAccountNumber() == acc_no && checkq.ssn.equals(ssn)){
                return checkq;
            }
        }
        return null;
    }

    public  boolean changePin(Customer customer,String ssn_new){
        for(Customer checkq : customers){
            if(checkq.name.equals(customer.name)){
                checkq.ssn = ssn_new;
                System.out.println("Pin successfully changed");
                return true;
            }
        }
        System.out.println("Something Went Wrong Try again");
        return false;
    }
    public  boolean changeName(Customer customer,String name_new){
        for(Customer checkq : customers){
            if(checkq.name.equals(customer.name)){
                checkq.name = name_new;
                System.out.println("Name successfully changed");
                return true;
            }
        }
        System.out.println("Something Went Wrong Try again");
        return false;
    }

    public void takeLoan(Customer customer,double loan_amount,int months){
        double interst = loan_amount*(double)(months/12)*customer.account.getInterst()/100;
        System.out.println("Your loan of "+loan_amount+"/- is given with an interest of "+interst+"/- for "+(double)months/12+" years!!");
    }

}
