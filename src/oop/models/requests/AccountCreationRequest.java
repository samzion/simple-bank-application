package oop.models.requests;

import oop.models.entities.Account;
import oop.models.entities.User;

public class AccountCreationRequest {
    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    private String userToken;




    public static String validate(AccountCreationRequest accountCreationRequest){
        if(accountCreationRequest == null){
            return "Account creation request cannot be null";
        }
        if(accountCreationRequest.getUserToken() == null || accountCreationRequest.getUserToken().isEmpty()){
            return "user token cannot be null or empty";
        }

        return "Account creation request okay!";
    }

    public static Account createAccountObject(AccountCreationRequest accountCreationRequest){
       Account account = new Account();


        return account;
    }
}
