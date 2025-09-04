package oop.services;

import oop.db.DataBaseConnection;
import oop.models.entities.User;
import oop.models.requests.UserCreationRequest;

import java.sql.*;
import java.time.LocalDateTime;

public class UserService {
    private Connection connection ;

    public UserService() throws SQLException, ClassNotFoundException {
        this.connection = DataBaseConnection.getConnection();
    }

    public UserService(Connection connection) {
       this.connection = connection;
    }

    public User createUser(UserCreationRequest userCreationRequest) throws SQLException {
        User user = UserCreationRequest.createUserObject(userCreationRequest);
        if(createUser(user)){
            return getUserDetailsByEmail(user.getEmail());
        }
        return  null;

    }

    private User getUserDetailsByEmail(String email) throws SQLException {
        String queryLoginDetails = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pStatement = connection.prepareStatement(queryLoginDetails);
        pStatement.setString(1, email);
        ResultSet rs = pStatement.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            System.out.println("A user with this email and password exist.");
            user.setId( rs.getInt("id")) ;
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
            user.setUpdatedOn(rs.getTimestamp("updated_on").toLocalDateTime());
            return  user;
        }
        return user;
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

        User user =  null;

        if(rs.next()){
            user = new User();
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

    public String confirmUserEmail(String email) throws SQLException {
        String queryEmail = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pStatementEmail = connection.prepareStatement(queryEmail);
        pStatementEmail.setString(1, email);
        ResultSet rsEmail = pStatementEmail.executeQuery();
        User user = new User();
        if(rsEmail == null){
           return "A user with this email does not exist";
//        } else {
//            rsEmail.next();
//                System.out.println("A user with this email and password exist.");
//                user.setId( rsEmail.getInt("id")) ;
//                user.setFirstName(rsEmail.getString("firstname"));
//                user.setLastName(rsEmail.getString("lastname"));
//                user.setAddress(rsEmail.getString("address"));
//                user.setEmail(rsEmail.getString("email"));
//                user.setPassword(rsEmail.getString("password"));
//                user.setGender(rsEmail.getString("gender"));
//                user.setCreatedOn(rsEmail.getTimestamp("created_on").toLocalDateTime());
//                user.setUpdatedOn(rsEmail.getTimestamp("updated_on").toLocalDateTime());
        }
        return "A user with this email exist";
    }

    public User getUserDetailsByUserToken(String userToken) throws SQLException {
        String queryLoginDetails = "SELECT * FROM users WHERE user_token = ?";
        PreparedStatement pStatement = connection.prepareStatement(queryLoginDetails);
        pStatement.setString(1, userToken);
        ResultSet rs = pStatement.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            System.out.println("A user with this email and password exist.");
            user.setId( rs.getInt("id")) ;
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
            user.setUpdatedOn(rs.getTimestamp("updated_on").toLocalDateTime());
            return  user;
        }
        return user;
    }

    public void updateToken(User existingUser) throws SQLException {
        String sql = "UPDATE users SET user_token = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, existingUser.getUserToken());
        statement.setInt(2, existingUser.getId());
        statement.executeUpdate();
    }


}
