package com.ppe;

import com.ppe.fiche.EtatFiche;
import com.ppe.fiche.Fiche;
import com.ppe.fiche.FraisForfaitaire.AutreFrais;
import com.ppe.fiche.FraisForfaitaire.Frais;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class FicheTab {

    @FXML
    private Tab tabfiche;

    @FXML
    private Text numFiche;

    @FXML
    private TableView<EtatFiche> etatFicheTable;

    @FXML
    private TableView<Frais> fraisFicheTable;

    @FXML
    private TableView<AutreFrais> autreFraisTable;

    private Fiche fiche;

    @FXML
    void event(Event ev) {

        if (tabfiche.isSelected()) {

            String str = tabfiche.getText();
            String numberOnly= str.replaceAll("[^0-9]", "");
            numFiche.setText(numberOnly);

            fiche = Context.getInstance().getDatabase().getOneFiche(Integer.parseInt(numberOnly));

            etatFicheTable.getItems().clear();
            etatFicheTable.getItems().addAll(Context.getInstance().getDatabase().getEtatFiche(Integer.parseInt(numberOnly)));

            fraisFicheTable.getItems().clear();
            fraisFicheTable.getItems().addAll(Context.getInstance().getDatabase().getFraisFiche(Integer.parseInt(numberOnly)));

            autreFraisTable.getItems().clear();
            autreFraisTable.getItems().addAll(Context.getInstance().getDatabase().getAutreFraisFiche(Integer.parseInt(numberOnly)));

        }

    }


}
