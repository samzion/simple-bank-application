package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.User;
import oop.services.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserLoginScreen {
    public void show() throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("USER LOGIN SCREEN");
        int count = 0;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter login details");
            System.out.println("Enter email: ");
            String userEmail = scanner.nextLine();
            System.out.println("Enter password: ");
            String userPassword = scanner.nextLine();
            UserService userService = new UserService();
            User user = new User(userService.confirmUserLoginDetails(userEmail, userPassword));
            if (user.getId() >= 1) {
//                AccountPromptScreen accountPromptScreen = new AccountPromptScreen();
                AccountPromptScreen.show(user);
            } else {
                System.out.println("Incorrect login details. ");
                count++;
                if(count == 4){
                    System.out.println("Sorry! Too many failed attempts");
                    return;
                }
            }

        }
    }
}
