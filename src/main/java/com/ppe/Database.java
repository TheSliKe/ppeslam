package com.ppe;

import com.ppe.user.User;

import java.sql.*;

public class Database {

    //database connection
    private final String URL = "jdbc:mysql://ppeslam.ddns.net/ppeslam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USERNAME = "ppe";
    private final String PASSWORD = "slamppe";

    //global connection for database
    private Connection conn;

    public Database(){

        try {
            //create the connection
            conn  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //login method that return true if entry exist in DB for that username and password
    public boolean login(String username, String password){

        String sql = "select count(*) FROM compte WHERE identifiant=\"" + username + "\" and mot_de_passe=\"" + password + "\";";
        Statement statement = null;

        try {

            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int res = result.getInt(1);

                if(res == 1)
                    return true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    //this method is call for set user info from DB in user Object
    public void infoUser(){

        User user = Context.getInstance().getUser();

        String sql = "select id_compte, nom, prenom, date_de_naissance, adresse, grade FROM compte WHERE identifiant=\"" + user.getUsername() + "\";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                user.setIdCompte(result.getInt(1));
                user.setLastname(result.getString(2));
                user.setName(result.getString(3));
                user.setBirthdate(result.getString(4));
                user.setAdresse(result.getString(5));
                user.setGrade(result.getInt(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
