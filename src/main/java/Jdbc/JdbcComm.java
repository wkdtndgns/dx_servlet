package Jdbc;

import java.sql.*;

public class JdbcComm {
    String url = "jdbc:mysql://localhost:3306/db01";
    String userName = "root";
    String password = "1234";

    Connection connection;

    public JdbcComm() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // or com.mysql.cj.jdbc.Driver for newer versions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        connection = DriverManager.getConnection(url, userName, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
