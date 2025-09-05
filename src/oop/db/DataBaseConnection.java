package oop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    //connect to postgres
    public static Connection getConnection( String dbUrl,  String user, String password,  String className ) throws SQLException, ClassNotFoundException {

        Class.forName(className);
        return DriverManager.getConnection(dbUrl, user, password);
    }

}
