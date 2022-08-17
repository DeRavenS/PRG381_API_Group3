package LayeredArch.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class ConnectDB{
    Connection conn = null;
    ResultSet resultSet = null;
    Statement statement = null;
    CallableStatement myCall = null;

    public Connection connectDatabase(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/BelgiumCampusDB_Group3";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            return conn;
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.\n" + e.getMessage());
            return conn;
        }
    }
}