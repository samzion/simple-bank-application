package oop;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import oop.bank.DefaultTransfer;
import oop.bank.GTBTransfer;
import oop.bank.ITransfer;
import oop.bank.UBATransfer;
import oop.db.DataBaseConnection;
import oop.db.migrations.MigrationRunner;
import oop.httpHandlers.*;
import oop.services.AccountService;
import oop.services.LoanService;
import oop.services.UserService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleBankRestApiApplication {

    // http(s)://host:port/create-user?firstName=kayode&lastName
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Connection connection = DataBaseConnection.getConnection();

        MigrationRunner migrationRunner = new MigrationRunner();
        migrationRunner.runMigrations(connection);
        try {
            // Create an HttpServer instance
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            UserService userService = new UserService(connection);
            AccountService accountService = new AccountService(connection);
            LoanService loanService = new LoanService();

            DefaultTransfer genericTransfer = new DefaultTransfer(accountService);
            GTBTransfer gtbTransfer = new GTBTransfer(accountService);
            UBATransfer ubaTransfer = new UBATransfer(accountService);
            List<ITransfer> genericTransfers = new ArrayList<>();
            genericTransfers.add(gtbTransfer);
            genericTransfers.add(ubaTransfer);
            genericTransfers.add(genericTransfer);
            TransferProcessor transferProcessor = new TransferProcessor(accountService, genericTransfers);

            // Create a context for a specific path and set the handler
            server.createContext("/", new MyHandler());
            //TODO: Create a landing page path called homeHandler to return all the APIs that is supported.
            server.createContext("/create-user", new UserCreationHandler(userService));
            server.createContext("/user-login", new UserLoginHandler(userService));
            server.createContext("/create-account", new AccountCreationHandler(userService, accountService));
            server.createContext("/list-accounts", new ListAccountHandler(userService, accountService));
            server.createContext("/deposit", new DepositHandler(userService, accountService));
            server.createContext("/withdraw", new WithdrawHandler(userService, accountService));
            server.createContext("/transfer", new TransferHandler(userService,transferProcessor));
            server.createContext("/collect-loan", new CollectLoanHandler(userService, accountService, loanService, transferProcessor));
            server.createContext("/pay-loan", new PayLoanHandler(userService, accountService, loanService, transferProcessor));

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

}