package com.bankApp;

import java.util.LinkedList;

public class Bank {
    LinkedList<Account> accounts = new LinkedList<Account>();
    String bankName;

    public Bank( String bankName) {
        this.bankName = bankName;
    }

    public void addToBank(Account account){
        boolean ff = false;
        for(Account checkedAccount: this.accounts){
            if(checkedAccount.getAccount_no().equals(account.getAccount_no())) {
                ff = true;
                break;
            }
        }
        if(ff){
            System.out.println("Already account existed");
        }else{
            accounts.add(account);
            System.out.println("Account successfully added to bank");
        }
    }


    public void removeFromBank(Account account){
        boolean ff = false;
        for(Account checkedAccount: this.accounts){
            if(checkedAccount.getAccount_no().equals(account.getAccount_no())) {
                ff = true;
                break;
            }
        }
        if(!ff){
            System.out.println("Account doesn't exist");
        }else{
            accounts.remove(account);
            System.out.println("Account successfully removed from bank");
        }
    }

    public void checkInBank(Account account){
        boolean ff = false;
        for(Account checkedAccount: this.accounts){
            if(checkedAccount.getAccount_no().equals(account.getAccount_no())) {
                ff = true;
                break;
            }
        }
        if(ff){
            System.out.println("Account existed");
        }else{
            System.out.println("Account Doesn't exists");
        }
    }

    public void BankAccounts(){
        if(this.accounts.size() >= 1){
            for(Account checkedAccount: this.accounts){
                checkedAccount.viewDetails();
            }
        }
        else{
            System.out.println("No accounts Existed");
        }

    }

    public LinkedList<Account> getAccounts() {
        return accounts;
    }

    public String getBankName() {
        return bankName;
    }
}
