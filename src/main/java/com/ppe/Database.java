package com.ppe;

import com.ppe.user.User;

import java.sql.*;

public class Database {

    //change to jdbc:mysql://ppeslam.ddns.net/ppeslam if not in local
    private final String URL = "jdbc:mysql://192.168.1.43:3306/ppeslam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USERNAME = "ppe";
    private final String PASSWORD = "slamppe";

    private Connection conn;

    public Database(){


        try {
            conn  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean login(String username, String password){

        boolean reponse = false;


        String sql = "select count(*) FROM compte WHERE identifiant=\"" + username + "\" and mot_de_passe=\"" + password + "\";";
        Statement statement = null;
        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int res = result.getInt(1);

                if(res == 1){
                    reponse = true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reponse;

    }

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
