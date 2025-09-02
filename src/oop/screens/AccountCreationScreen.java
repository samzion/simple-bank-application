package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.User;
import oop.services.AccountService;

import java.sql.SQLException;
import java.util.Random;

public class AccountCreationScreen {
    public static boolean createAccount(User user) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        Random random = new Random();
        while(true){
            String accountNumber = String.valueOf(random.nextLong(1000000000,1100000000));
            AccountService accountService =  new AccountService();
            String[] banks = {"uba", "gtb", "default"};
            String bank = banks[new Random().nextInt(banks.length)];
            if(accountService.createAccount(user, accountNumber, bank)){
                System.out.println("Your account number is " + accountNumber);
                return true;
            }
        }
    }
}
//TODO: try and catch exception to catch duplicate account numbers