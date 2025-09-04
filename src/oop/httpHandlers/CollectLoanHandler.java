package oop.httpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.TransferProcessor;
import oop.models.entities.Account;
import oop.models.entities.User;
import oop.models.requests.CollectLoanRequest;
import oop.models.response.AccountOperationResponse;
import oop.services.AccountService;
import oop.services.LoanService;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class CollectLoanHandler extends BaseHandler implements HttpHandler {
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
        CollectLoanRequest collectLoanRequest = gson.fromJson(body, CollectLoanRequest.class);
        String validationMessage = CollectLoanRequest.validate(collectLoanRequest);
        if(!validationMessage.equals("Collect loan request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }

        Account destinationAccount = new Account();
        try {
            AccountService accountService = new AccountService();
            destinationAccount = accountService.confirmAccountDetails(
                    collectLoanRequest.getDestinationAccountNumber()
            );

            if (destinationAccount == null) {
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 404, "Destination account not found");
                return;
            }

        } catch (SQLException | ClassNotFoundException e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }

        try{
            String sourceAccountNumber = "1018521126";//Sammy Bank Central account number
            UserService userservice = new UserService();
            User sourceUser = userservice.getUserByAccountNumber(sourceAccountNumber);
            AccountOperationResponse transferResponse = TransferProcessor.transfer(sourceUser, sourceAccountNumber, collectLoanRequest.getDestinationAccountNumber(),collectLoanRequest.getLoanAmount());
            LoanService loanService = new LoanService();
            loanService.createLoan(destinationAccount, collectLoanRequest.getLoanAmount());
            SimpleBankRestApiApplication.writeHttpResponse(exchange, transferResponse.getStatusCode(), transferResponse.getMessage());

        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }
}
