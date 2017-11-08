package com.sabel.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonService {


    private static final String URL = "jdbc:sqlite:d:\\Test.sqlite";
    private Connection connection;
    private Statement statement;


    public PersonService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void save(Person person) throws SQLException {
        String sql = "INSERT INTO person VALUES(" + person.getId() + ", '" + person.getNachname() + "', " + person.getJahrgang() + ")";
        this.statement.executeQuery(sql);
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        statement = null;

        if (connection!= null){
            connection.close();
        }
        connection = null;
    }
}
