package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("101", "Alice", 1000.0);
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getAccountBalance(), 0.001);
    }

    @Test
    void testDepositInvalidAmount() {
        account.deposit(-200.0);
        assertEquals(1000.0, account.getAccountBalance(), 0.001);
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getAccountBalance(), 0.001);
    }

    @Test
    void testWithdrawInvalidAmount() {
        account.withdraw(-100.0);
        assertEquals(1000.0, account.getAccountBalance(), 0.001);
    }

    @Test
    void testWithdrawExceedingBalance() {
        account.withdraw(1500.0);
        assertEquals(1000.0, account.getAccountBalance(), 0.001);
    }

    @Test
    void testGetAccountNumber() {
        assertEquals("101", account.getAccountNumber());
    }

    @Test
    void testCreateAccountWithoutInitialDeposit() {
        BankAccount newAccount = new BankAccount("789012", "Jane Smith", 0.0);
        assertEquals(0.0, newAccount.getAccountBalance(), 0.001);
        assertEquals("789012", newAccount.getAccountNumber());
    }

    @Test
    void testDisplayInformation() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        account.displayInformation();

        System.setOut(originalOut);

        String printedOutput = outputStream.toString();

        assertTrue(printedOutput.contains("Account Number: 123456"));
        assertTrue(printedOutput.contains("Holder Name   : John Doe"));
        assertTrue(printedOutput.contains("Balance       : ₱1000.00"));
    }
}
