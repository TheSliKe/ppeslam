package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class SaisieFrais {

    //get this tab
    @FXML
    private Tab tab4;

    @FXML
    private RadioButton newFiche;

    @FXML
    private RadioButton existFiche;

    @FXML
    private RadioButton fraisForfait;

    @FXML
    private RadioButton autreFrais;

    @FXML
    private ChoiceBox ficheList;

    @FXML
    private TextField Forfait1;
    @FXML
    private TextField Forfait2;
    @FXML
    private TextField Forfait3;
    @FXML
    private TextField Forfait4;
    @FXML
    private TextField Forfait5;
    @FXML
    private TextField Forfait6;

    @FXML
    private TextField autre1;
    @FXML
    private TextField autre2;
    @FXML
    private TextField autre3;
    @FXML
    private TextField autre4;


    private User user;
    private Tabs tabs;


    //main init from app
    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab4);
        tabs.setTabs(tabList);

        ToggleGroup toggleGroup1 = new ToggleGroup();

        newFiche.setToggleGroup(toggleGroup1);
        existFiche.setToggleGroup(toggleGroup1);

        ToggleGroup toggleGroup2 = new ToggleGroup();

        fraisForfait.setToggleGroup(toggleGroup2);
        autreFrais.setToggleGroup(toggleGroup2);

    }

    //init when the tab is selected
    @FXML
    void event(Event ev) {

        if (tab4.isSelected()) {



        }

    }

    @FXML
    private void newFiche(){

        ficheList.setDisable(true);


    }

    @FXML
    private void existFiche(){

        ficheList.setDisable(false);

        ficheList.getItems().clear();
        ficheList.setItems(Context.getInstance().getDatabase().getFicheList());

    }

    @FXML
    private void fraisForfait(){

        Forfait1.setDisable(false);
        Forfait2.setDisable(false);
        Forfait3.setDisable(false);
        Forfait4.setDisable(false);
        Forfait5.setDisable(false);
        Forfait6.setDisable(false);

        autre1.setDisable(true);
        autre2.setDisable(true);
        autre3.setDisable(true);
        autre4.setDisable(true);

    }

    @FXML
    private void autreFrais(){

        Forfait1.setDisable(true);
        Forfait2.setDisable(true);
        Forfait3.setDisable(true);
        Forfait4.setDisable(true);
        Forfait5.setDisable(true);
        Forfait6.setDisable(true);

        autre1.setDisable(false);
        autre2.setDisable(false);
        autre3.setDisable(false);
        autre4.setDisable(false);

    }


    @FXML
    private void send(){

        if (newFiche.isSelected() && !existFiche.isSelected()){
            System.out.println("nouvelle fiche");

            String matricule = Integer.toString(Context.getInstance().getDatabase().createFiche());

            if (fraisForfait.isSelected() && !autreFrais.isSelected()){
                System.out.println("fraisForfait");

                String qtNuit = Forfait1.getText();
                String qtRepas = Forfait2.getText();
                String qtKilometre = Forfait3.getText();

                String puNuit = Forfait4.getText();
                String puRepas = Forfait5.getText();
                String puKilometre = Forfait6.getText();

                Context.getInstance().getDatabase().sendFraisForfait(matricule, qtNuit, qtRepas, qtKilometre ,puNuit, puRepas, puKilometre);

            } else if (!fraisForfait.isSelected() && autreFrais.isSelected()) {
                System.out.println("autreFrais");

                String date = autre1.getText();
                String libelle = autre2.getText();
                String montant = autre3.getText();
                String justificatif = autre4.getText();

                Context.getInstance().getDatabase().sendAutreFrais(matricule, date, libelle, montant, justificatif);

            }else{
                System.out.println("pas de selection");
            }





        } else if (!newFiche.isSelected() && existFiche.isSelected()){
            System.out.println("fiche existante");

            String matricule = (String) ficheList.getValue();
            if (matricule == null){
                System.out.println("pas de fiche selectionner");
            } else {
                System.out.println(matricule);

                if (fraisForfait.isSelected() && !autreFrais.isSelected()){
                    System.out.println("fraisForfait");

                    String qtNuit = Forfait1.getText();
                    String qtRepas = Forfait2.getText();
                    String qtKilometre = Forfait3.getText();

                    String puNuit = Forfait4.getText();
                    String puRepas = Forfait5.getText();
                    String puKilometre = Forfait6.getText();

                    Context.getInstance().getDatabase().sendFraisForfait(matricule, qtNuit, qtRepas, qtKilometre ,puNuit, puRepas, puKilometre);

                } else if (!fraisForfait.isSelected() && autreFrais.isSelected()) {
                    System.out.println("autreFrais");

                    String date = autre1.getText();
                    String libelle = autre2.getText();
                    String montant = autre3.getText();
                    String justificatif = autre4.getText();

                    Context.getInstance().getDatabase().sendAutreFrais(matricule, date, libelle, montant, justificatif);

                }else{
                    System.out.println("pas de selection");
                }

            }


        } else {
            System.out.println("pas de selection");
        }

    }

}
