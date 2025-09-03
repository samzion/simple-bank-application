package oop;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import oop.db.DataBaseConnection;
import oop.db.migrations.MigrationRunner;
import oop.httpHandlers.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.SQLException;

public class SimpleBankRestApiApplication {

    // http(s)://host:port/create-user?firstName=kayode&lastName
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Connection connection = DataBaseConnection.getConnection();

        MigrationRunner migrationRunner = new MigrationRunner();
        migrationRunner.runMigrations(connection);
        try {
            // Create an HttpServer instance
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            // Create a context for a specific path and set the handler
            server.createContext("/", new MyHandler());
            //TODO: Create a landing page path called homeHandler to return all the APIs that is supported.
            server.createContext("/create-user", new UserCreationHandler());
            server.createContext("/user-login", new UserLoginHandler());
            server.createContext("/create-account", new AccountCreationHandler());
            server.createContext("/list-accounts", new ListAccountHandler());
            server.createContext("/deposit", new DepositHandler());
            server.createContext("/search", new SearchHandler());

            // Start the server
            server.setExecutor(null); // Use the default executor
            server.start();

            System.out.println("Server is running on port 8000");
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }

    // Define a custom HttpHandler
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            String method = exchange.getRequestMethod();

            if(!"get".equalsIgnoreCase(method)) {
                // Handle the request
                String response = "Method not allowed";
                exchange.sendResponseHeaders(405, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
                return;
            }
            // Handle the request
            String response = "Hello, this is a simple HTTP server response!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Define a custom HttpHandler


    // Define a custom HttpHandler
    static class SearchHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            if (!"get".equalsIgnoreCase(method)) {
                // Handle the request
                String response = "Method not allowed";
                exchange.sendResponseHeaders(405, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
                return;
            }
            // Handle the request
            String response = exchange.getRequestURI().getQuery();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void writeHttpResponse(HttpExchange exchange, int statusCode, String responseMessage) throws IOException {
        // Handle the request
        exchange.sendResponseHeaders(statusCode, responseMessage.length());
        OutputStream os = exchange.getResponseBody();
        os.write(responseMessage.getBytes());
        os.close();
    }
}