package com.driver;

import java.util.ArrayList;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String accountNumber = "";
        if(sum>digits*9)
        {
            throw new Exception("Account Number can not be generated");
        }
        while(sum>9)
        {
            accountNumber += '9';
            sum -= 9;
            digits--;
        }
        accountNumber += sum;
        digits--;
        while(digits>0)
        {
            accountNumber += '0';
            digits--;
        }

        return accountNumber;
    }



    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double remainingBalance = this.balance - amount;
        if(remainingBalance<minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance = remainingBalance;

    }

}