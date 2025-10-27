package com.BankApp;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private double newBalance;
    Date timestamp;

    public Transaction(String type, double amount, double newBalance){
        this.type = type;
        this.amount = amount;
        this.newBalance = newBalance;
        this.timestamp = new Date();
    }
    public String getTransactionSummary(){
        return "[ "+ this.timestamp + "] - "+this.type + ": ₹"+this.amount+ " New Balance: ₹"+newBalance;
    }
}
