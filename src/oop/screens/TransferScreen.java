package oop.screens;

import oop.SimpleBankCliApplication;
import oop.TransactionType;
import oop.TransferProcessor;
import oop.models.entities.Account;
import oop.services.AccountService;
import oop.services.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;


public class TransferScreen {
    public void show(Account sourceAccount) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("Welcome to Transfer Screen!");
        Scanner scanner =  new Scanner(System.in);
        double amountToTransfer;

        Account destinationAccount = new Account();
        while(true){
            System.out.println("Enter amount to transfer: ");
            amountToTransfer = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter destination account: ");
            AccountService accountService =  new AccountService();
            destinationAccount = accountService.confirmAccountDetails(scanner.nextLine());
            if(destinationAccount == null ){
                System.out.println("Invalid destination account.");
                continue;
            }
            if(TransferProcessor.transfer(amountToTransfer, sourceAccount, destinationAccount)){
                TransactionService transactionService =  new TransactionService();
                sourceAccount.setBalance(sourceAccount.getBalance());
                destinationAccount.setBalance(destinationAccount.getBalance());
                if(accountService.updateAccount(sourceAccount) &&
                        transactionService.createTransaction(sourceAccount, amountToTransfer, TransactionType.DEBIT)){
                    accountService.updateAccount(destinationAccount);
                    transactionService.createTransaction(destinationAccount, amountToTransfer, TransactionType.CREDIT);
                    return;
                }
            }
        }
    }
}
