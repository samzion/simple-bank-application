package oop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

    //connect to postgres
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "some_user";
    private static final String password = "some_password";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

}
