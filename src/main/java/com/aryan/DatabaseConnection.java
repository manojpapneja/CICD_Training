package com.aryan;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/UserDB"; // Replace with your DB URL
    private static final String DB_USER = "root"; // Replace with your DB username
    private static final String DB_PASSWORD = "Stab@123"; // Replace with your DB password

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
