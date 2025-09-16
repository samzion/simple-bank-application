package oop.httpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.User;
import oop.models.requests.WithdrawRequest;
import oop.models.response.AccountOperationResponse;
import oop.services.AccountService;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class WithdrawHandler extends BaseHandler implements HttpHandler {
    private AccountService accountService;

    public WithdrawHandler(UserService userService, AccountService accountService){
        super(userService);
        this.accountService = accountService;

    }
    public void handle (HttpExchange exchange) throws IOException {
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
        String body = "{}";
        try (InputStream input = exchange.getRequestBody()) {
            body =  new String(input.readAllBytes(), StandardCharsets.UTF_8);
        }
        WithdrawRequest withdrawRequest = gson.fromJson(body, WithdrawRequest.class);
        String validationMessage = WithdrawRequest.validate(withdrawRequest);
        if(!validationMessage.equals("Withdrawal request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }
        try{

            AccountOperationResponse withdrawResponse =this.accountService.withdraw(authenticatedUser, withdrawRequest.getAccountNumber()
                    , withdrawRequest.getWithdrawAmount());
            SimpleBankRestApiApplication.writeHttpResponse(exchange, withdrawResponse.getStatusCode(), withdrawResponse.getMessage());

        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }
}
