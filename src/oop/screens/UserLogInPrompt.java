package oop.screens;

import oop.SimpleBankApplication;

import java.sql.SQLException;
import java.util.Scanner;

public class UserLogInPrompt {

    void show() throws SQLException, ClassNotFoundException {
        SimpleBankApplication.clearConsole();

        while(true){
            System.out.println("Enter 1 to create a user account");
            System.out.println("Enter 2 to log in to your user account");
            System.out.println("Enter 0 to exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            if (userInput==1){
                SimpleBankApplication.clearConsole();
                UserCreationScreen userCreationScreen = new UserCreationScreen();
                userCreationScreen.show();
            } else if (userInput ==2){
                SimpleBankApplication.clearConsole();
                UserLoginScreen userLoginScreen = new UserLoginScreen();
                userLoginScreen.show();
            } else if (userInput == 0) {
                return;
            }
        }

    }
}
//TODO: handling to go back to previous screen. i.e method must return a value