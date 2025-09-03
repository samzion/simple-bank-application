package oop.services;

import oop.TransactionType;
import oop.db.DataBaseConnection;
import oop.models.entities.Account;
import oop.models.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    Connection connection ;

    public AccountService() throws SQLException, ClassNotFoundException {
       connection = DataBaseConnection.getConnection();
    }


    public boolean createAccount(User user, String accountNumber, String bank) throws SQLException {
        boolean flag = false;

        String query = """
                        INSERT INTO accounts
                            (user_id, account_number, account_name, bank)
                            values (?, ?, ?, ?)
                       """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user.getId());
        statement.setString(2, accountNumber);
        statement.setString(3, user.getFirstName() + " "+ user.getLastName());
        statement.setString(4, bank);
        statement.executeUpdate();
        System.out.println("Account Created successfully!");
        return true;
    }

    public boolean updateAccount(Account account) throws SQLException {
        boolean flag = false;

        String query = """
                        UPDATE accounts
                                  SET balance = ?,
                                  updated_on = CURRENT_TIMESTAMP
                                  WHERE account_number = ?;
                       """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1, account.getBalance());
        statement.setString(2, account.getAccountNumber());
        statement.executeUpdate();
        System.out.println("Account updated successfully!");
        return true;
    }

    public List<Account> listAccount(User user) throws SQLException {
        String query = """
                        SELECT *
                        FROM accounts
                        WHERE user_id = ?
                       """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user.getId());
        ResultSet rs = statement.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while(true){
            if(rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUserID(rs.getInt("user_id"));
                account.setAccountNumber(rs.getString("account_number"));
                account.setAccountName(rs.getString("account_name"));
                account.setBank(rs.getString("bank"));
                account.setBalance(rs.getInt("balance"));
                account.setCreatedON(rs.getTimestamp("created_on").toLocalDateTime());
                account.setUpdatedON(rs.getTimestamp("updated_on").toLocalDateTime());
                accounts.add(account);
            } else {
                break;
            }
        }
        return  accounts;
    }

    public Account confirmAccountDetails(String accountNumber) throws SQLException {
        String queryLoginDetails = "SELECT * FROM accounts WHERE account_number = ?";
        PreparedStatement pStatement = connection.prepareStatement(queryLoginDetails);
        pStatement.setString(1, accountNumber);
        ResultSet rs = pStatement.executeQuery();
        Account account = new Account();
        if (rs.next()) {
            System.out.println("The account number exist.");
            account.setId(rs.getInt("id"));
            account.setAccountNumber(rs.getString("account_number"));
            account.setUserID(rs.getInt("user_id"));
            account.setAccountName(rs.getString("account_name"));
            account.setBank(rs.getString("bank"));
            account.setBalance(rs.getDouble("balance"));
            account.setCreatedON(rs.getTimestamp("created_on").toLocalDateTime());
            account.setUpdatedON(rs.getTimestamp("updated_on").toLocalDateTime());
            return account;
        }
        return null;
    }

    public Account confirmAccountDetails(int accountId) throws SQLException {
        String queryLoginDetails = "SELECT * FROM accounts WHERE id = ?";
        PreparedStatement pStatement = connection.prepareStatement(queryLoginDetails);
        pStatement.setInt(1, accountId);
        ResultSet rs = pStatement.executeQuery();
        Account account = new Account();
        if (rs.next()) {
            System.out.println("The account number exist.");
            account.setId(rs.getInt("id"));
            account.setAccountNumber(rs.getString("account_number"));
            account.setUserID(rs.getInt("user_id"));
            account.setAccountName(rs.getString("account_name"));
            account.setBank(rs.getString("bank"));
            account.setBalance(rs.getDouble("balance"));
            account.setCreatedON(rs.getTimestamp("created_on").toLocalDateTime());
            account.setUpdatedON(rs.getTimestamp("updated_on").toLocalDateTime());
            return account;
        }
        return null;
    }

    public String deposit( User user, String accountNumber, double depositAmt) throws SQLException, ClassNotFoundException {
        if(depositAmt <=100){
            System.out.println( "Invalid figure");
            return "Invalid figure";
        }
        List<Account> accounts = new AccountService().listAccount(user);
        if(accounts == null){
            return "You have no existing account";
        }
        for(Account account: accounts){
            if(account.getAccountNumber().equalsIgnoreCase(accountNumber)){
                TransactionService transactionService = new TransactionService();
                double balance =  account.getBalance();
                balance+=depositAmt;
                account.setBalance(balance);
                AccountService accountService = new AccountService();
                if(accountService.updateAccount(account)){
                    transactionService.createTransaction(account, depositAmt, TransactionType.CREDIT);
                    System.out.println("Deposit of " + depositAmt + " into " + account.getAccountNumber() + "'s account is successful");
                    return "Deposit request successful!";
                }
            }
        }
        return "Invalid account number";
    }

}
