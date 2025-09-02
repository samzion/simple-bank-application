package oop;

import oop.db.DataBaseConnection;
import oop.db.migrations.MigrationRunner;
import oop.screens.WelcomeScreen;

import java.sql.Connection;
import java.sql.SQLException;

public class SimpleBankCliApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DataBaseConnection.getConnection();

        MigrationRunner migrationRunner = new MigrationRunner();
        migrationRunner.runMigrations(connection);
        clearConsole();

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.show();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

}
