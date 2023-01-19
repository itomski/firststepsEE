package de.lubowiecki.firststeps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:8889/firststeps_db"; // Port für WIN 3306
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // Für WIN ist leer

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Import zur Laufzeit
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
