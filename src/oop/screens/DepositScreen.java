package oop.screens;

import oop.SimpleBankCliApplication;
import oop.TransactionType;
import oop.models.entities.Account;
import oop.services.AccountService;
import oop.services.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;


public class DepositScreen {
    public void show(Account account) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("Welcome to Deposit Screen!");
        Scanner scanner =  new Scanner(System.in);
        double amountToDeposit;
        while(true){
            System.out.println("Enter amount to deposit: ");
            amountToDeposit = scanner.nextDouble();
            if(account.deposit(amountToDeposit)){
                AccountService accountService = new AccountService();
                TransactionService transactionService =  new TransactionService();
                if(accountService.updateAccount(account) &&
                        transactionService.createTransaction(account, amountToDeposit, TransactionType.CREDIT)){
                    return;
                }
            }
        }
    }
}
