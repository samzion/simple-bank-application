package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.Account;
import oop.models.entities.Loan;
import oop.services.AccountService;
import oop.services.LoanService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PayLoanScreen {
    public void show(Account sourceAcct) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("Welcome to Pay Loan Screen!");
        System.out.println("Checking if you have taken any loan......... ");
        List<Loan> loans = new ArrayList<>();
        LoanService loanService = new LoanService();
        loans = loanService.listLoans(sourceAcct);
        if(loans.isEmpty()){
            System.out.println("You have not taken any load before.");
            System.out.println("You might be eligible to take loans. ");
            return;
        } else {
            System.out.println("OK! You have taken a loan(s) before. ");
            sourceAcct.setLoans(loans);
            Scanner scanner = new Scanner(System.in);
            double amountToPay;
            String sammyBankCentralAccountNumber = "1018521126";
            Account destinationAcct = new Account();
            while (true) {
                System.out.println("Enter amount you want to pay: ");
                amountToPay = scanner.nextDouble();
                AccountService accountService = new AccountService();
                destinationAcct = accountService.confirmAccountDetails(sammyBankCentralAccountNumber);
                if (sourceAcct.payLoan(amountToPay, destinationAcct)) {
                    System.out.println("Loan payment successful and all entities updated!");
                    return;
                }
                System.out.println("Loan payment and entities updates failed!");
                return;
            }

        }
    }
}
