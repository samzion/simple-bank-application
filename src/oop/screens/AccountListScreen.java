package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.Account;
import oop.models.entities.User;
import oop.services.AccountService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountListScreen {
    public static List<Account> listAccount(User user) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        AccountService accountService = new AccountService();
        List<Account> accounts = new ArrayList<>();
        accounts = accountService.listAccount(user);
        if (accounts.isEmpty()){
            System.out.printf("""
                                    Dear %s,
                                    You have no account with SAMMY Bank yet.
                                    
                                    \n""" ,
                    user.getFirstName()
            );
            return  null;
        } else {
            System.out.printf("""
                                    Dear %s %s,
                                    Your accounts: .
                                    
                                    \n""" ,
                    user.getFirstName(), user.getLastName()
            );
            int count = 0;
            System.out.println("##################################################################################");
            System.out.println("S/N)    " + "Account Number" + "      "  + "Bank" + "          "  + " Total Credit  " + "     "  +  " Total Debit" + "       "+ "Current Available Balance");
            for(Account account:accounts){
                count++;
                System.out.println();
                System.out.println(count + "         " + account.toString());
            }
            System.out.println("##################################################################################");
            return accounts;
        }
    }
}
