package com.BankApp;

import java.security.ProtectionDomain;
import java.util.List;

public abstract class Account {
    protected String AccountNumber;
    protected String AccountHolderName;
    protected double AccountBalance;
    protected int PIN;
    protected List<Transaction> transactionHistory;

    public Account(String AccountNumber, String AccountHolderName, double initialDeposit, int pin){
        this.AccountNumber = AccountNumber;
        this.AccountHolderName = AccountHolderName;
        this.AccountBalance = initialDeposit;
        this.PIN = pin;

        // Initializing the transaction array
        this.transactionHistory = new java.util.ArrayList<>();

        // First Transaction
        Transaction initialTransaction = new Transaction("INITIAL DEPOSIT",initialDeposit,initialDeposit);
        this.transactionHistory.add(initialTransaction);

    }

    public boolean verifyPIN(int pin){
        return this.PIN == pin;
    }
    public double check_account_balance(int pin){
        if(verifyPIN(pin)){
            return this.AccountBalance;
        }
        return Integer.MIN_VALUE;
    }

    public void deposit(int amount){
        if(amount > 0){
            this.AccountBalance += amount;
            Transaction deposit_transaction = new Transaction("DEPOSIT",amount,this.AccountBalance);
            this.transactionHistory.add(deposit_transaction);

        }
        else{
            System.out.println("Amount cannot be less than zero..");
        }
    }


    abstract void cash_withdrawl(int amount, int pin);
//        if(verifyPIN(pin) && this.AccountBalance >= amount){
//            this.AccountBalance -= amount;
//            return true;
//        }
//        return false;

    public void printAllTransactions(){
        for (Transaction transaction : this.transactionHistory){
            System.out.println(transaction.getTransactionSummary());
        }
    }

    public boolean pinChange(int pin, int newPin, String AccountNumber){
        if(AccountNumber.equals(this.AccountNumber))
        {
            System.out.println("Are you changing the PIN of "+this.AccountHolderName+" ?");
            if(pin==this.PIN){
                System.out.println("Account pin of this account will be changes.......");
                if((newPin+"").length()==4){
                    this.PIN = newPin;
                    System.out.println("New PIN Has been setted up");
                    return true;
                }
                else{
                    System.out.println("New PIN should be not more than 4 digits.....");
                    return false;
                }
            }
            else{

                System.out.println("Enter your current PIN Correctly!......");
                return false;
            }
        }
        else{
            System.out.println("There is no account found with this "+AccountNumber+" (Account Number).....");
            return false;
        }

    }
}

