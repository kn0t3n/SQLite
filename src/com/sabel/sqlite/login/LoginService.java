package com.sabel.sqlite.login;

import java.sql.*;

public class LoginService {

    private Connection connection;
    private static final String URL = "jdbc:sqlite:d:\\Personen.sqlite";
    private Statement statement;

    public LoginService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public boolean login(String loginname, String password) throws SQLException {
        String sql = "SELECT loginname, password FROM login WHERE loginname = '" + loginname + "' AND password = '" + password + "'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }
}
