package oop.httpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.Account;
import oop.models.entities.User;
import oop.services.AccountService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class AccountCreationHandler extends BaseHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if(!this.isValidRequestMethod(exchange, "post")) {
            // Handle the request
            String response = "Method not allowed";
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 405, response);
            return;
        }
        User authenticatedUser = this.getAuthenticatedUser(exchange);
        if(authenticatedUser == null) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 401, "Unauthorized!");
            return;
        }
        try{
                AccountService accountService = new AccountService();
                Account newCreatedAccount =   accountService.confirmAccountDetails(createAccountFromUserDetails(authenticatedUser));
                newCreatedAccount.setTransactions(null);
                newCreatedAccount.setLoans(null);
                String jsonResponse = gson.toJson(newCreatedAccount);
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 200, jsonResponse);

        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }

    private static String createAccountFromUserDetails(User existingUser) throws SQLException, ClassNotFoundException {
        AccountService accountService = new AccountService();
        String accountNumber;
        Random random = new Random();
        while(true){
            accountNumber = String.valueOf(random.nextLong(1000000000,1100000000));
            String[] banks = {"uba", "gtb", "default"};
            String bank = banks[new Random().nextInt(banks.length)];
            if(accountService.createAccount(existingUser, accountNumber, bank)){
                System.out.println("Your account number is " + accountNumber);
                return accountNumber;
            }
        }
    }
}
