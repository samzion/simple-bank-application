package oop.httpHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import oop.SimpleBankRestApiApplication;
import oop.models.entities.User;
import oop.models.requests.UserCreationRequest;
import oop.others.LocalDateTimeAdapter;
import oop.services.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class AccounListHandler implements HttpHandler {
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
        UserCreationRequest userCreationRequest = gson.fromJson(body, UserCreationRequest.class);
        String validationMessage = UserCreationRequest.validate(userCreationRequest);
        if(!validationMessage.equals("User creation request okay!")){
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 400, validationMessage);
            return;
        }
        User newCreatedUser= null;
        try {
            UserService userService = new UserService();
            newCreatedUser = userService.createUser(userCreationRequest);
            if(newCreatedUser == null){
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unable to create user");
            } else {
                String jsonResponse = gson.toJson(newCreatedUser);
                SimpleBankRestApiApplication.writeHttpResponse(exchange, 200, jsonResponse);
            }
        } catch (Exception e) {
            SimpleBankRestApiApplication.writeHttpResponse(exchange, 500, "Unknown error from server");
        }
    }
}