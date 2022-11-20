package com.dynamicBank;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    Bank bank = new Bank("Bank of Kings");
    boolean exit;

    public static void main(String[] args){
        Main main = new Main();
        Account account1 = new Account();
        account1 = new Saving(1000);
        Customer customer1 = new Customer("Swarup","6637",account1);
        main.bank.addCustomer(customer1);
        main.viewDetails(customer1);
        main.runMenu();

    }

    private void runMenu(){
        printHeader();
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private void performAction(int choice) {
        switch (choice){
            case  0:
                System.out.println("Thanks you for using our app. Have a good day");
                System.exit(0);
                break;
            case 1:
                createAccount();
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdrawl();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                otherMenu();
                break;
            default:System.out.println("Unknown Error occurred");
        }
    }

    private void checkBalance() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no,ssn);
        if(customer == null){
            System.out.println("Invalid User Credentials");
            System.exit(0);
        }
        else{
            viewDetails(customer);
        }
    }

    private void makeWithdrawl() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no,ssn);
        if(customer == null){
            System.out.println("Invalid User Credentials");
            System.exit(0);
        }
        else{
            System.out.print("Enter the Deposit Amount : ");
            double amount = sc.nextDouble();
            if(amount > 0){
                if( customer.account.getBalance() - amount >= 100){
                    customer.account.setBalance(customer.account.getBalance()-amount);
                    System.out.println("Successfully Withdrawn");
                }else{
                    System.out.println("Min balance is required");
                }
            }
            else{
                System.out.println("Min amount to withdrawn is greater than 0");
            }
        }
    }

    private void makeDeposit() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no,ssn);
        if(customer == null){
            System.out.println("Invalid User Credentials");
            System.exit(0);
        }
        else{
            System.out.print("Enter the Deposit Amount : ");
            double amount = sc.nextDouble();
            if(amount > 0){
                customer.account.setBalance(customer.account.getBalance()+amount);
                System.out.println("Successfully Deposited");
            }
            else{
                System.out.println("Min amount to deposit is greater than 0");
            }
        }

    }

    private void createAccount() {
        String name,ssn,accountType="";
        double intialDeposit=0;
        boolean valid = false;
        while (!valid){
            System.out.print("Enter the account type(saving|checking) : ");
            accountType = sc.nextLine();
            if(accountType.equalsIgnoreCase("saving") || accountType.equalsIgnoreCase("checking")){
                valid = true;
            }
            else {
                System.out.println("Enter a valid option");
            }
        }
        System.out.print("Enter your name : ");
        name = sc.nextLine();
        System.out.print("Enter your security Number : ");
        ssn = sc.nextLine();
        valid = false;
        while(!valid){
            System.out.print("Enter your initial Deposit : ");
            try{
                intialDeposit = Double.parseDouble(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Initial Deposit must be a number!!");
            }
            if(accountType.equalsIgnoreCase("checking")){
                if(intialDeposit < 100) {
                    System.out.println("Minimum initial deposit is 100/-");
                }
                else{
                    valid = true;
                }
            }
            else{
                if(intialDeposit < 50){
                    System.out.println("Minimum initial deposit is 50/-");
                }
                else{
                    valid = true;
                }
            }
        }
        Account account;
        if (accountType.equalsIgnoreCase("saving")){
            account = new Checking(intialDeposit);
            System.out.println("Savings Account Created");
        }
        else{
            account = new Saving(intialDeposit);
            System.out.println("Checking Account Created");
        }

        Customer customer = new Customer(name,ssn,account);
        bank.addCustomer(customer);
        viewDetailsaccc(customer,accountType);
    }

    private  void otherMenu(){
        System.out.println("The menu of the bank:");
        System.out.println("Enter: \n 0) Go back\n " +
                "1) Take a loan \n " +
                "2) Change Name \n " +
                "3) Change Pin \n ");
        int choice = -1;
        do {
            System.out.print("Please enter the choice : ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection please try again,Only integers accepted");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid Input please try again");
            }
        }while (choice < 0 || choice > 4);
        switch(choice){
            case 0:
                runMenu();
            case 1:
                takeLoan();
                break;
            case 2:
                changeName();
                break;
            case 3:
                changePin();
                break;
            default:System.out.println("Unknown Error occurred");

        }

    }

    private void takeLoan() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no, ssn);
        if (customer == null) {
            System.out.println("Invalid User Credentials");
            System.exit(0);
        } else {
            System.out.print("Enter your required Loan Amount : ");
            double loan_amount = sc.nextDouble();
            System.out.print("Enter your required time(In months) : ");
            int months = sc.nextInt();
            bank.takeLoan(customer,loan_amount,months);
        }
    }


    private void changeName() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no, ssn);
        if (customer == null) {
            System.out.println("Invalid User Credentials");
            System.exit(0);
        } else {
            System.out.print("Enter your new Name : ");
            String name_new = sc.next();
            bank.changeName(customer,name_new);
        }
    }

    private void changePin() {
        System.out.print("Enter your Bank Account Number : ");
        int acc_no = sc.nextInt();
        System.out.print("Enter your Bank Account ssn : ");
        String ssn = sc.next();
        Customer customer = bank.checkValidation(acc_no, ssn);
        if (customer == null) {
            System.out.println("Invalid User Credentials");
            System.exit(0);
        } else {
            System.out.print("Enter your new SSN : ");
            String ssn_new = sc.next();
            bank.changePin(customer,ssn_new);
        }
    }

    private void viewDetails(Customer customer){
        System.out.println("-".repeat(30));
        System.out.println("Name : "+customer.name);
        System.out.println("Account Number : "+customer.account.getAccountNumber());
        System.out.println("Balance : "+customer.account.getBalance());
        System.out.println("-".repeat(30));
    }

    public void viewDetailsaccc(Customer customer,String accountType){
        System.out.println("-".repeat(30));
        System.out.println("Name : "+customer.name);
        System.out.println("Account Number : "+customer.account.getAccountNumber());
        System.out.println("Account Type : "+accountType);
        System.out.println("Balance : "+customer.account.getBalance());
        System.out.println("-".repeat(30));
    }
    private int getInput() {
        int choice = -1;
        do {
            System.out.print("Please enter the choice : ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection please try again,Only integers accepted");
            }
            if (choice < 0 || choice > 5) {
                System.out.println("Invalid Input please try again");
            }
        }while (choice < 0 || choice > 5);
        return choice;
    }

    private void printMenu() {
        System.out.println("The menu of the bank:");
        System.out.println("Enter: \n 0) Exit\n " +
                "1) Create a new Account \n " +
                "2) Make a Deposit \n " +
                "3) Make a Withdrawal \n " +
                "4) Display account balance \n " +
                "5) Others");
    }

    private void printHeader() {
        System.out.println("-".repeat(30));
        System.out.println("Welcome to "+bank.bankName);
        System.out.println("-".repeat(30));
    }
}
