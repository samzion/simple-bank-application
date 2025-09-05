package oop.screens;

import oop.SimpleBankCliApplication;
import oop.TransactionType;
import oop.models.entities.Account;
import oop.services.AccountService;
import oop.services.LoanService;
import oop.services.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;


public class CollectLoanScreen {
    public void show(Account destinationAcct) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("Welcome to Collect Loan Screen!");
        Scanner scanner =  new Scanner(System.in);
        double loanAmount;

        Account sourceAccount = new Account();
        while(true){
            System.out.println("Enter amount you want to collect: ");
            loanAmount = scanner.nextDouble();
            scanner.nextLine();
            AccountService accountService =  new AccountService();
            sourceAccount = accountService.confirmAccountDetails("1018521126");
            if(destinationAcct.collectLoan(loanAmount, sourceAccount)){
                TransactionService transactionService =  new TransactionService();
                destinationAcct.setBalance(destinationAcct.getBalance());
                sourceAccount.setBalance(sourceAccount.getBalance());
                if(accountService.updateAccountBalance(destinationAcct) && transactionService.createTransaction(destinationAcct, loanAmount, TransactionType.CREDIT)){
                       accountService.updateAccountBalance(sourceAccount);
                       transactionService.createTransaction(sourceAccount, loanAmount, TransactionType.DEBIT);
                       LoanService loanService = new LoanService();
                       if(loanService.createLoan(destinationAcct, loanAmount)){
                           return;
                       }
                }
            }
        }
    }
}
