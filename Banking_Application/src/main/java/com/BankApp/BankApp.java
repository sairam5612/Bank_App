package com.BankApp;


public class BankApp {

    public static void main(String[] args) {
        System.out.println("--- Welcome to the Bank Simulation ---");

        // --- 1. Create Accounts ---
        // We are using the new constructors: (Number, Name, Initial Deposit, PIN, Rate)
        System.out.println("\n--- Creating Accounts ---");
        SavingsAccount sa = new SavingsAccount("SA-001", "Alice", 1000.0, 1234, 0.03);
        CheckingAccount ca = new CheckingAccount("CA-002", "Bob", 500.0, 9876, 0.01);
        System.out.println("Created Savings Account for Alice with initial PIN 1234.");
        System.out.println("Created Checking Account for Bob with initial PIN 9876.");

        // --- 2. Test PIN Management (Alice) ---
        System.out.println("\n--- Testing PIN Management for Alice (SA-001) ---");
        System.out.println("\nBalance check with WRONG PIN (5555):");
        double balance = sa.check_account_balance(5555);
        System.out.println("Result: " + (balance == Integer.MIN_VALUE ? "Access Denied" : "Balance: " + balance));

        System.out.println("\nBalance check with CORRECT PIN (1234):");
        balance = sa.check_account_balance(1234);
        System.out.println("Result: " + (balance == Integer.MIN_VALUE ? "Access Denied" : "Balance: " + balance));

        System.out.println("\nAttempt PIN change with WRONG old PIN (1111 -> 2222):");
        boolean pinChanged = sa.pinChange(1111, 2222, "SA-001");
        System.out.println("PIN change successful: " + pinChanged);

        System.out.println("\nAttempt PIN change with INVALID new PIN (1234 -> 55555):");
        pinChanged = sa.pinChange(1234, 55555, "SA-001");
        System.out.println("PIN change successful: " + pinChanged);

        System.out.println("\nAttempt PIN change with CORRECT details (1234 -> 4321):");
        pinChanged = sa.pinChange(1234, 4321, "SA-001");
        System.out.println("PIN change successful: " + pinChanged);

        System.out.println("\nBalance check with OLD PIN (1234):");
        balance = sa.check_account_balance(1234);
        System.out.println("Result: " + (balance == Integer.MIN_VALUE ? "Access Denied" : "Balance: " + balance));

        System.out.println("\nBalance check with NEW PIN (4321):");
        balance = sa.check_account_balance(4321);
        System.out.println("Result: " + (balance == Integer.MIN_VALUE ? "Access Denied" : "Balance: " + balance));

        // --- 3. Test SavingsAccount (Alice) Transactions ---
        System.out.println("\n--- Testing Transactions for Alice (SA-001) ---");
        System.out.println("\nAttempt deposit of 200:");
        sa.deposit(200); // New balance 1200

        System.out.println("\nAttempt deposit of -50 (invalid):");
        sa.deposit(-50); // Fails

        System.out.println("\nAttempt withdrawal of 300 with NEW PIN (4321):");
        sa.cash_withdrawl(300, 4321); // Success, new balance 900

        System.out.println("\nAttempt withdrawal of 100 with WRONG PIN (1111):");
        sa.cash_withdrawl(100, 1111); // Fails, bad PIN

        System.out.println("\nAttempt withdrawal of 1000 (insufficient funds) with NEW PIN (4321):");
        sa.cash_withdrawl(1000, 4321); // Fails, balance is 900

        System.out.println("\nAttempt withdrawal of -100 (invalid) with NEW PIN (4321):");
        sa.cash_withdrawl(-100, 4321); // Fails, negative amount

        System.out.println("\nApplying interest:");
        sa.interestApply(); // (Note: Your code logs this as "WITH DRAWL")

        // --- 4. Test CheckingAccount (Bob) Transactions ---
        System.out.println("\n--- Testing Transactions for Bob (CA-002) ---");
        System.out.println("\nBalance check with initial PIN (9876):");
        balance = ca.check_account_balance(9876);
        System.out.println("Result: " + (balance == Integer.MIN_VALUE ? "Access Denied" : "Balance: " + balance));

        System.out.println("\nAttempt deposit of 100:");
        ca.deposit(100); // New balance 600

        System.out.println("\nAttempt withdrawal of 50 with WRONG PIN (1234):");
        ca.cash_withdrawl(50, 1234); // Fails, bad PIN

        System.out.println("\nAttempt withdrawal of 250 with CORRECT PIN (9876):");
        ca.cash_withdrawl(250, 9876); // Success, new balance 350

        System.out.println("\nAttempt withdrawal of 500 (insufficient funds):");
        ca.cash_withdrawl(500, 9876); // Fails, balance is 350

        System.out.println("\nApplying interest:");
        ca.interestApply();

        // --- 5. Print Final Transaction Histories ---
        System.out.println("\n\n--- Final Transaction History for Alice (SA-001) ---");
        sa.printAllTransactions();

        System.out.println("\n\n--- Final Transaction History for Bob (CA-002) ---");
        ca.printAllTransactions();
    }
}