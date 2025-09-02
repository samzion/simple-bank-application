package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.Account;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountOperationScreen {

    public static void show(Account account) throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        Scanner scanner =  new Scanner(System.in);
        System.out.println("What kind of operation would you want to perform?");
        int userInput;
        while(true){
            System.out.println("Enter 1 to deposit");
            System.out.println("Enter 2 to withdraw");
            System.out.println("Enter 3 to transfer");
            System.out.println("Enter 4 to collect loan");
            System.out.println("Enter 5 to pay loan");
            System.out.println("Enter 0 to exit");
            userInput = scanner.nextInt();
            if(userInput ==0){
                System.out.println("Thank You for banking with us.");
                return;
            }
            switch (userInput) {
                case 1 : {
                    //deposit
                    DepositScreen depositScreen = new DepositScreen();
                    depositScreen.show(account);
                    break;
                }
                case 2 : {
                    //withdraw
                    WithdrawalScreen withdrawalScreen = new WithdrawalScreen();
                    withdrawalScreen.show(account);
                    break;
                }
                case 3 : {
                    //transfer
                    System.out.println("Linking to transfer page...");
                    TransferScreen transferScreen = new TransferScreen();
                    transferScreen.show(account);
                    break;
                }
                case 4 : {
                    //collect
                    CollectLoanScreen collectLoanScreen = new CollectLoanScreen();
                    collectLoanScreen.show(account);
                    break;
                }
                case 5 : {
                    //pay loan
                    PayLoanScreen payLoanScreen = new PayLoanScreen();
                    payLoanScreen.show(account);
                    break;
                }
                default:  {
                    System.out.println("Invalid selection!");
                }
            }

        }

    }


}
