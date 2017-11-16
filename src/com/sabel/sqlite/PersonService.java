package com.sabel.sqlite;

import java.sql.*;

public class PersonService {


    private static final String URL = "jdbc:sqlite:d:\\Personen.sqlite";
    private Connection connection;
    private Statement statement;


    public PersonService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        statement = null;

        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    public void save(Person person) throws SQLException {
        String sql = "INSERT INTO person VALUES(" + person.getId() + ", '" + person.getNachname() + "', " + person.getJahrgang() + ")";
        this.statement.executeUpdate(sql);
    }

    public Person readPerson(int idsuche) throws SQLException {
        Person person = null;
        ResultSet resultSet = null;
        resultSet = statement.executeQuery("SELECT id, nachname, jahrgang FROM person WHERE id =" + String.valueOf(idsuche));
        if (resultSet.next()) {
            String name = resultSet.getString("nachname");
            int jahrgang = resultSet.getInt(3);
            person = new Person(idsuche, name, jahrgang);
            System.out.println(person);
        }
        return person;
    }
}
