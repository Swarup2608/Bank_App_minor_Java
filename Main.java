package com.bankApp;

public class Main {
    public static void main(String[] args) {
        Account swarup = new Account("Swarup", "swarup@gmail.com", 20.02, "1234567890", "9390671273", "1234");
        swarup.printBalance();
        swarup.depositMoney(1000.02);
        swarup.withdrawMoney(100000);
        swarup.withdrawMoney(100);
        swarup.printBalance();
        swarup.viewDetails();

        Bank b1 = new Bank("Bank of King Kong");
        b1.addToBank(swarup);
        b1.checkInBank(swarup);
        b1.BankAccounts();
        b1.removeFromBank(swarup);
        b1.BankAccounts();

    }
}