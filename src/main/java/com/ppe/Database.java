package com.ppe;

import com.ppe.fiche.EtatFiche;
import com.ppe.fiche.Fiche;
import com.ppe.fiche.FraisForfaitaire.*;
import com.ppe.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Database {

    //database connection
    private final String URL = "jdbc:mysql://juliendupale.ddns.net/ppeslam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

    public ObservableList<Fiche> getFiche(){

        ObservableList<Fiche> FicheData = FXCollections.observableArrayList();

        User user = Context.getInstance().getUser();

        String sql = "SELECT a.id_fiche, (SELECT count(*) FROM etat_de_fiche as b WHERE a.id_fiche=b.id_fiche) as nbetat FROM fiche as a WHERE fk_id_compte=" + user.getIdCompte() + ";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                System.out.println(result.getString(1) + result.getInt(2));


                if (result.getInt(2) == 1){

                    String sql2 = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + result.getInt(1) +";";
                    Statement statement2 = null;

                    try {
                        statement2 = conn.createStatement();

                        ResultSet result2 = statement2.executeQuery(sql2);

                        while (result2.next()){

                            FicheData.add(new Fiche(result2.getString(1),result2.getString(2), result2.getString(3)));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else if (result.getInt(2) == 2) {

                    String sql2 = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + result.getInt(1) +" and a.id_etat=2 ;";
                    Statement statement2 = null;

                    try {
                        statement2 = conn.createStatement();

                        ResultSet result2 = statement2.executeQuery(sql2);

                        while (result2.next()){

                            FicheData.add(new Fiche(result2.getString(1),result2.getString(2), result2.getString(3)));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else if (result.getInt(2) == 3) {

                    String sql2 = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + result.getInt(1) +" and a.id_etat=3 ;";
                    Statement statement2 = null;

                    try {
                        statement2 = conn.createStatement();

                        ResultSet result2 = statement2.executeQuery(sql2);

                        while (result2.next()){

                            FicheData.add(new Fiche(result2.getString(1),result2.getString(2), result2.getString(3)));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else if (result.getInt(2) == 4) {

                    String sql2 = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + result.getInt(1) +" and a.id_etat=4 ;";
                    Statement statement2 = null;

                    try {
                        statement2 = conn.createStatement();

                        ResultSet result2 = statement2.executeQuery(sql2);

                        while (result2.next()){

                            FicheData.add(new Fiche(result2.getString(1),result2.getString(2), result2.getString(3)));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else if (result.getInt(2) == 5) {

                    String sql2 = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + result.getInt(1) +" and a.id_etat=5 ;";
                    Statement statement2 = null;

                    try {
                        statement2 = conn.createStatement();

                        ResultSet result2 = statement2.executeQuery(sql2);

                        while (result2.next()){

                            FicheData.add(new Fiche(result2.getString(1),result2.getString(2), result2.getString(3)));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        System.out.println(FicheData.size());
        return FicheData;
    }


    public Fiche getOneFiche(int numFiche){

        Fiche fiche = null;

        User user = Context.getInstance().getUser();

        String sql = "SELECT a.id_fiche, c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.id_fiche=" + numFiche +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                fiche = new Fiche(result.getString(1),result.getString(2), result.getString(3));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fiche;
    }

    public  ObservableList<EtatFiche> getEtatFiche(int numFiche){

        ObservableList<EtatFiche> etatFicheData = FXCollections.observableArrayList();

        User user = Context.getInstance().getUser();

        String sql = "SELECT c.libelle, a.date FROM etat_de_fiche as a inner join fiche as b on a.id_fiche=b.id_fiche inner join etat as c on a.id_etat=c.id_etat where b.fk_id_compte=" + user.getIdCompte() +" and a.id_fiche=" + numFiche +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                etatFicheData.add(new EtatFiche(result.getString(1),result.getString(2)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etatFicheData;
    }

    public  ObservableList<Frais> getFraisFiche(int numFiche){

        ObservableList<Frais> fraisData = FXCollections.observableArrayList();

        User user = Context.getInstance().getUser();

        String sql = "SELECT qte_nuitee, montant_unitaire_nuitee, qte_repas_midi, montant_unitaire_repas_midi, qte_kilometrage, montant_unitaire_kilometrage FROM ppeslam.fiche WHERE id_fiche=" + numFiche +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                Nuit n = new Nuit(result.getInt(1), result.getInt(2));
                Repas r = new Repas(result.getInt(3), result.getInt(4));
                Kilometre k = new Kilometre(result.getInt(5), result.getInt(6));

                fraisData.add(new Frais("Nuit", n.getqNuit(), n.puNuitProperty(), n.totalNuitProperty()));
                fraisData.add(new Frais("Repas", r.getqRepas(), r.getPuRepas(), r.getTotalRepas()));
                fraisData.add(new Frais("Kilometrage", k.getqKilometre(), k.getPuKilometre(), k.getTotalKilometre()));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fraisData;
    }

    public ObservableList<AutreFrais> getAutreFraisFiche(int numFiche){

        ObservableList<AutreFrais> autreFraisData = FXCollections.observableArrayList();

        User user = Context.getInstance().getUser();

        String sql = "SELECT libelle, date, montant, justificatif FROM autre_frais WHERE fk_id_fiche=" + numFiche +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                autreFraisData.add(new AutreFrais(result.getString(1),result.getString(2),result.getString(3),result.getString(4)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autreFraisData;
    }

    public ObservableList<String> getFicheList(){

        ObservableList<String> ficheListData = FXCollections.observableArrayList();

        User user = Context.getInstance().getUser();

        String sql = "SELECT id_fiche FROM fiche WHERE fk_id_compte=" + user.getIdCompte() +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                ficheListData.add(result.getString(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ficheListData;
    }


    public void sendFraisForfait(String matricule, String qNuit, String qRepas, String qKilometre, String puNuit, String puRepas, String puKilometre){

        System.out.println(matricule + " " + qNuit + " " + puNuit + " " +qRepas + " " + puRepas+ " " + qKilometre + " " + puKilometre);

        String sql = "SELECT qte_nuitee, montant_unitaire_nuitee, qte_repas_midi, montant_unitaire_repas_midi, qte_kilometrage, montant_unitaire_kilometrage FROM fiche WHERE id_fiche=" + matricule +";";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

               System.out.println(result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5)+result.getString(6));

                String sql2 = "UPDATE fiche SET qte_nuitee=?, montant_unitaire_nuitee=?, qte_repas_midi=?, montant_unitaire_repas_midi=?, qte_kilometrage=?, montant_unitaire_kilometrage=? WHERE id_fiche=?";

                PreparedStatement statement2 = conn.prepareStatement(sql2);
                statement2.setInt(1, result.getInt(1) + Integer.valueOf(qNuit));
                statement2.setInt(2, result.getInt(2) + Integer.valueOf(puNuit));
                statement2.setInt(3, result.getInt(3) + Integer.valueOf(qRepas));
                statement2.setInt(4, result.getInt(4) + Integer.valueOf(puRepas));
                statement2.setInt(5, result.getInt(5) + Integer.valueOf(qKilometre));
                statement2.setInt(6, result.getInt(6) + Integer.valueOf(puKilometre));
                statement2.setInt(7, Integer.valueOf(matricule));

                int rowsUpdated = statement2.executeUpdate();
                System.out.println(rowsUpdated);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void sendAutreFrais(String matricule, String date, String libelle, String montant, String justificatif){

        System.out.println(matricule + date + libelle + montant + justificatif);
        try {
            String sql = "INSERT INTO autre_frais (date, libelle, montant, justificatif, fk_id_fiche) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, date);
            statement.setString(2, libelle);
            statement.setInt(3, Integer.valueOf(montant));
            statement.setString(4, justificatif);
            statement.setInt(5, Integer.valueOf(matricule));

            int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int createFiche(){

        User user = Context.getInstance().getUser();

        try {
            String sql = "INSERT INTO fiche (fk_id_compte) VALUES (?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getIdCompte());

            int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = 0;
        String sql = "SELECT LAST_INSERT_ID();";
        Statement statement = null;

        try {
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){

                id = result.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql2 = "INSERT INTO etat_de_fiche (date, id_fiche, id_etat) VALUES (curdate(), ?, 1)";

            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, id);

            int rowsInserted = statement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;

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
