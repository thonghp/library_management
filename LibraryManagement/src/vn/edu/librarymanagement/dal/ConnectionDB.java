package vn.edu.librarymanagement.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnectionInSQLServer() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=LibraryManagement";
        String username = "sa";
        String password = "sa";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
    }

    public static Connection getConnectionInMySQL() throws Exception {
        // Class.forName("com.mysql.jdbc.Driver"); // driver này cũ r
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/library_management";
        String username = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
    }
}
