package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;

        while (true){
            System.out.println("""
                    ===== Bank MENU =====
                    1. Create Account
                    2. View All Accounts
                    3. Check Balance
                    4. Deposit
                    5. Withdraw
                    6. Exit
                    """);
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    depositToAccount();
                    break;
                case 5:
                    withdrawFromAccount();
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-6.");
            }

        }
    }

    private static void createAccount(){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();

        double initialDeposit = 0;
        System.out.print("Initial deposit? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes")) {
            System.out.print("Enter initial deposit amount: ₱");
            initialDeposit = scanner.nextDouble();
            scanner.nextLine();
            if (initialDeposit < 0) {
                System.out.println("Initial deposit cannot be negative. Setting to ₱0.00.");
                initialDeposit = 0;
            }
        }

        BankAccount newAccount = new BankAccount(accountNumber, name, initialDeposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully!\n");
    }

    private static void viewAllAccounts(){
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (BankAccount account : accounts) {
                account.displayInformation();
            }
        }
    }

    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.printf("Current Balance: ₱%.2f\n", account.getAccountBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void depositToAccount() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();
        BankAccount account = findAccount(accNo);

        if (account != null) {
            System.out.print("Enter deposit amount: ₱");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawFromAccount() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();
        BankAccount account = findAccount(accNo);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ₱");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
}