package oop.httpHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.Account;
import oop.models.entities.User;
import oop.models.requests.AccountCreationRequest;
import oop.others.LocalDateAdapter;
import oop.others.LocalDateTimeAdapter;
import oop.services.AccountService;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class AccountCreationHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        if(!"post".equalsIgnoreCase(method)) {
            // Handle the request
            String response = "Method not allowed";
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 405, response);
            return;
        }
        String body = "{}";
        try (InputStream input = exchange.getRequestBody()) {
            body =  new String(input.readAllBytes(), StandardCharsets.UTF_8);
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        AccountCreationRequest accountCreationRequest = gson.fromJson(body, AccountCreationRequest.class);
        String validationMessage = AccountCreationRequest.validate(accountCreationRequest);
        if(!validationMessage.equals("Account creation request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }
        User  existingUser = null;
        Account newCreatedAccount= null;
        try {
            UserService userService = new UserService();
            String userToken = accountCreationRequest.getUserToken();
            existingUser = userService.getUserDetailsByUserToken(userToken);

            if(existingUser == null){
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unable to create account");
            } else {
                AccountService accountService = new AccountService();
                newCreatedAccount =   accountService.confirmAccountDetails(createAccountFromUserDetails(existingUser));
                newCreatedAccount.setTransactions(null);
                newCreatedAccount.setLoans(null);
                String jsonResponse = gson.toJson(newCreatedAccount);
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 200, jsonResponse);
            }
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
