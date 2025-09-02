package oop.screens;

import oop.SimpleBankCliApplication;

import java.sql.SQLException;
import java.util.Scanner;

public class WelcomeScreen {

    public void show() throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("WELCOME TO SAMMY BANK");

        while(true){
            System.out.println("Enter 1 to continue or 0 to exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            if (userInput==1){
                SimpleBankCliApplication.clearConsole();
                UserLogInPrompt userLogInPrompt = new UserLogInPrompt();
                userLogInPrompt.show();
                break;
            } else if (userInput ==0){
                    return;
            }
        }
        System.out.println("Good Bye!!!");

    }
}
