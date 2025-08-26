package oop.screens;

import oop.SimpleBankApplication;
import oop.TransactionType;
import oop.models.Account;
import oop.services.AccountService;
import oop.services.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;


public class WithdrawalScreen {
    public void show(Account account) throws SQLException, ClassNotFoundException {
        SimpleBankApplication.clearConsole();
        System.out.println("Welcome to Withdrawal Screen!");
        Scanner scanner =  new Scanner(System.in);
        double amountToWithdraw;
        while(true){
            System.out.println("Enter amount to withdraw: ");
            amountToWithdraw = scanner.nextDouble();
            if(account.withdraw(amountToWithdraw)){
                AccountService accountService = new AccountService();
                TransactionService transactionService =  new TransactionService();
                if(accountService.updateAccount(account) &&
                        transactionService.createTransaction(account, amountToWithdraw, TransactionType.DEBIT)){
                    return;
                }
            }
        }
    }
}
