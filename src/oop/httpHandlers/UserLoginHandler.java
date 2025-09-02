package oop.httpHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.User;
import oop.models.requests.UserCreationRequest;
import oop.models.requests.UserLoginRequest;
import oop.others.LocalDateTimeAdapter;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserLoginHandler implements HttpHandler {
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
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        UserLoginRequest userLoginRequest = gson.fromJson(body, UserLoginRequest.class);
        String validationMessage = UserLoginRequest.validate(userLoginRequest);
        if(!validationMessage.equals("User login request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }
        User existingUser;
        try {
            UserService userService = new UserService();
            existingUser = userService.confirmUserLoginDetails(userLoginRequest.getEmail(), userLoginRequest.getPassword());

            if(existingUser == null){
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 401, "Incorrect login details");
            }else {
                String uuid = UUID.randomUUID().toString().replace("-", "");
                existingUser.setUserToken(uuid);
                userService.updateToken(existingUser);
                existingUser.setPassword(null);
                String jsonResponse = gson.toJson(existingUser);
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 200, jsonResponse);
            }
        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }
}