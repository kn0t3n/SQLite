package com.sabel.sqlite;

import java.sql.SQLException;

public class TestPersonService {

    public static void main(String[] args) {

        Person person = new Person(1, "Maier", 1976);
        Person person2 = new Person(2, "bla", 1999);

        PersonService personService = null;

        try {
            personService = new PersonService();
            personService.save(person);
            personService.save(person2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                personService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        try {
            personService = new PersonService();
            personService.readPerson(1);
            personService.readPerson(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                personService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
