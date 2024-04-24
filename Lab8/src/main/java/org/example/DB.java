package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/Library";
    private static final String USER = "mysql";
    private static final String PASSWORD = "student";
    private static Connection connection = null;

    private DB() {}
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                createConnection();
            }
        } catch (SQLException e) {
            System.err.println("Eroare la verificarea stării conexiunii: " + e.getMessage());
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Eroare la crearea conexiunii la baza de date: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Eroare la închiderea conexiunii la baza de date: " + e.getMessage());
            }
        }
    }
}
