package oop.screens;

import oop.SimpleBankCliApplication;
import oop.models.entities.User;
import oop.services.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserCreationScreen {

    public void show() throws SQLException, ClassNotFoundException {
        SimpleBankCliApplication.clearConsole();
        System.out.println("USER CREATION SCREEN");

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your first name: ");
            String userFirstName = scanner.nextLine();
            System.out.println("Enter your last name: ");
            String userLastName = scanner.nextLine();
            String userGender;
            while(true){
                System.out.println("Enter your gender, M for male, F for female or Enter 0 to exit");
                userGender = scanner.nextLine();
                if("M".equalsIgnoreCase(userGender) || "F".equalsIgnoreCase(userGender)){
                    break;
                } else if("0".equals(userGender)){
                    return;
                }
            }
            System.out.println("Enter your email: ");
            String userEmail = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            System.out.println("Enter your address: ");
            String userAddress = scanner.nextLine();
            User user = new User(userFirstName,userLastName,userGender, userEmail, userAddress, password);
           while(true){
               System.out.println();
               System.out.println("Please, confirm user details: " + user);
               System.out.println("Enter 1 to create");
               System.out.println("Enter 2 to re-enter details");
               System.out.println("Enter 0 to exit");
               int confirmUserDetail = scanner.nextInt();
               if(confirmUserDetail == 1){
                   UserService userService = new UserService();
                   boolean isCreateUserSuccessful = userService.createUser(user);
                   if(isCreateUserSuccessful){
                       UserLogInPrompt userLogInPrompt =  new UserLogInPrompt();
                       userLogInPrompt.show();
                       return;
                   } else {
                        break;
                   }
               }else if(confirmUserDetail == 2){
                   break;
               } else if( confirmUserDetail == 0){
                   return;
               }
           }

        }
    }
}
//TODO: validate user email