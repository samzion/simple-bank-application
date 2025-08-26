package oop.services;

import oop.db.DataBaseConnection;
import oop.models.User;

import java.sql.*;
import java.time.LocalDateTime;

public class UserService {
    Connection connection ;

    public UserService() throws SQLException, ClassNotFoundException {
       connection = DataBaseConnection.getConnection();
    }

    public boolean createUser(User user) throws SQLException {
        boolean flag = false;
        //check if email exist in database before
        String checkEmail = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pStatement = connection.prepareStatement(checkEmail);
        pStatement.setString(1, user.getEmail());
        ResultSet rs = pStatement.executeQuery();

        if(rs.next()){
            System.out.println("A user with this email exist. ");
            return  false;
        }

        String query = """
                        INSERT INTO users
                            (firstname, lastname, gender, email, address, password, created_on, updated_on)
                            values (?, ?, ?, ?, ?,?,?,?)
                       """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getGender());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getAddress());
        statement.setString(6, user.getPassword());
        statement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
        statement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
        statement.executeUpdate();
        System.out.println("User Created successfully!");
        return true;
    }

    public User confirmUserLoginDetails(String email, String password) throws SQLException {
        String queryLoginDetails = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement pStatement = connection.prepareStatement(queryLoginDetails);
        pStatement.setString(1, email);
        pStatement.setString(2, password);
        ResultSet rs = pStatement.executeQuery();
        User user = new User( );
        if(rs.next()){
            System.out.println("A user with this email and password exist.");
            user.setId( rs.getInt("id")) ;
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setGender(rs.getString("gender"));
            user.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
            user.setUpdatedOn(rs.getTimestamp("updated_on").toLocalDateTime());
            return  user;
        }
        return user;
    }
}
