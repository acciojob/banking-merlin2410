package com.driver;

public class Main {
    public static void main(String[] args) {

        try{
            SavingsAccount s = new SavingsAccount("Merlin", 10000, 5000,5);
            StudentAccount studentAccount = new StudentAccount("Arun",5000,"CET");
            CurrentAccount currentAccount = new CurrentAccount("Rahul",15000,"AABACD");
            s.withdraw(5000);
            s.withdraw(5000);
            currentAccount.validateLicenseId();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}