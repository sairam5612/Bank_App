
package com.BankApp;
public class CheckingAccount extends Account{
    private double interestRate;
    private final String AccountType = "Checking Account";
    CheckingAccount(String AccountNumber, String AccountHolder, double initialDeposit,int pin, double rate){
        super(AccountNumber,AccountHolder,initialDeposit,pin);
        this.interestRate = rate;
    }

    @Override
    public void cash_withdrawl(int amount, int pin){
        if(this.verifyPIN(pin) && this.AccountBalance >= amount){
            this.AccountBalance -= amount;
            Transaction withdrawalTransaction = new Transaction("WITH DRAWL",amount,this.AccountBalance);
            this.transactionHistory.add(withdrawalTransaction);
            System.out.println("With Drew ₹ "+amount+". New Balance: ₹ "+this.AccountBalance);

        }
        else if(this.AccountBalance <= amount){
            System.out.println("Error : Insufficient funds. Cannot withdraw ₹ "+amount);
        }
        else if(amount <=0){
            System.out.println("Amount cannot be zero or less than zero...");
        }
        else{
            System.out.println("PIN is invalid. Please re-Check it...");
        }
    }

    public void interestApply(){
        double interestValue = super.AccountBalance*this.interestRate;
        this.AccountBalance += interestValue;
        Transaction withdrawalTransaction = new Transaction("WITH DRAWL",interestValue,this.AccountBalance);
        this.transactionHistory.add(withdrawalTransaction);
        System.out.println("Interest of ₹ "+interestValue + " applied. New Balance ₹ "+this.AccountBalance);
    }

    public String getAccountType() {
        return AccountType;
    }

}
