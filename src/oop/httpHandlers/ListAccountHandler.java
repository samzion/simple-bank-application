package oop.httpHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.Account;
import oop.models.entities.User;
import oop.models.requests.AccountListRequest;
import oop.models.requests.AccountListResponse;
import oop.others.LocalDateAdapter;
import oop.others.LocalDateTimeAdapter;
import oop.services.AccountService;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ListAccountHandler implements HttpHandler {
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
        AccountListRequest accountListRequest = gson.fromJson(body, AccountListRequest.class);
        String validationMessage = AccountListRequest.validate(accountListRequest);
        if(!validationMessage.equals("Account list request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }
        User  existingUser = null;
        List<Account> accounts= null;
        try {
            UserService userService = new UserService();
            String userToken = accountListRequest.getUserToken();
            existingUser = userService.getUserDetailsByUserToken(userToken);

            if(existingUser == null){
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, "You have no existing account");
            } else {
                AccountService accountService = new AccountService();
                accounts =   accountService.listAccount(existingUser);
                AccountListResponse accountListResponse = new AccountListResponse();
                accountListResponse.setAccounts(accounts);
                String jsonResponse = gson.toJson(accountListResponse);
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 200, jsonResponse);
            }
        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }

}
