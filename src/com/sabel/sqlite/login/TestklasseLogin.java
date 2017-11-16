package com.sabel.sqlite.login;

import javax.swing.*;
import java.sql.SQLException;

public class TestklasseLogin {
    public static void main(String[] args) throws SQLException {

//        Login login = new Login("maier", "andreas");
        LoginService loginService = new LoginService();
//        try {
//            LoginService loginService2 = new LoginService();
//            System.out.println(loginService.login(login.getLoginName(), login.getPassword()));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//        }

        boolean isLoggedIn = false;
        do{
            String loginname = JOptionPane.showInputDialog(null, "Bitte Loginname eingeben");
            String password  = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben");
            isLoggedIn = loginService.login(loginname, password);
        } while (isLoggedIn);
        System.out.println("Login erfolgreich");

    }
}
