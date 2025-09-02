package oop.bank;

import oop.models.entities.Account;

public class DefaultTransfer implements ITransfer{

    protected String bank = "default";

    public String getBank() {
        return bank;
    }

    public boolean transfer(double amount, Account source, Account destination){
        boolean withdrawSuccessful = source.withdraw(amount);
        if(withdrawSuccessful){
            boolean depositSuccessful = destination.deposit(amount);
            if(depositSuccessful) {
                System.out.println("Using " + bank + " Transfer");
                System.out.println(source.getAccountName() + " Transferred " + amount + " to " + destination.getAccountName() + " successful!!!");
                return true;
            } else {
                System.out.println(bank + " Transfer from " + source + " to "  + destination + " not successful");
                return false;
            }
        } else {
            System.out.println(bank + " Transfer from " + source + " to "  + destination + " not successful");
            return false;
        }
    }
}