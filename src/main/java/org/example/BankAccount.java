package org.example;

public class BankAccount {
    private final String accountNumber;
    private final String accountName;
    private double accountBalance;

    public BankAccount(String accountNumber, String accountName, double initialDeposit){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            accountBalance += amount;
            System.out.println("Successfully deposited ₱" + amount);
        }
    }

    public void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient balance.");
        } else {
            accountBalance -= amount;
            System.out.println("Successfully withdrew ₱" + amount);
        }
    }

    public void displayInformation(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name   : " + accountName);
        System.out.printf("Balance       : ₱%.2f\n", accountBalance);
        System.out.println("---------------------------");
    }

}
