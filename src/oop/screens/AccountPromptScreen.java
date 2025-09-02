package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.Account;
import oop.models.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountPromptScreen {

    public static void show(User user) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();

        System.out.println("Dear " + user.getFirstName() +"," );
        System.out.println("What will you like me to do for you?");
        Scanner scanner =  new Scanner(System.in);
        int userInput;
        while(true){
            System.out.println("Enter 1 to create an account");
            System.out.println("Enter 2 to list accounts");
            System.out.println("Enter 0 to exit");
            userInput = scanner.nextInt();
            if(userInput == 1){
               if(AccountCreationScreen.createAccount(user)){
                   System.out.println("Continue to list accounts to use account(s)");
                    continue;
               } else {
                   System.out.println("Account creation failed!!!");
                   System.out.println("Continue to use other accounts by listing your  accounts");
               }
            } else if (userInput == 2) {
                List<Account> accounts = new ArrayList<>();
                accounts = AccountListScreen.listAccount(user);
                if(accounts == null){
                    System.out.println("Continue to create account");
                    continue;
                }else {

                    int chooseAccountSerialNo;
                    while(true){
                        System.out.println("""
                                        If you would like to perform an account operation,
                                        then enter the S/N of the account of interest.
                                        OR
                                        Enter 0 if No"""
                        );
                        chooseAccountSerialNo = scanner.nextInt();
                        if(chooseAccountSerialNo >=1 && chooseAccountSerialNo   <= accounts.size()){
                            AccountOperationScreen.show(accounts.get(chooseAccountSerialNo-1));

                        } else if (chooseAccountSerialNo == 0){
                            System.out.println("Ok. You don't want to perform an account operation");
                            break;
                        } else {
                            System.out.println("Invalid selection");
                        }
                    }


                }
            } else if(userInput ==0){
                System.out.println("Good bye!!!");
                return;
            } else System.out.println("Invalid selection!!!");
        }



    }

}
