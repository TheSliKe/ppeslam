package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class FichePage {

    //get this tab
    @FXML
    private Tab tab2;

    //get tableview from FXML
    @FXML
    private TableView ficheTable;

    //get table column from FXML
    @FXML
    private TableColumn fraisforfaitaire;
    @FXML
    private TableColumn autrefrais;

    //create sub column for fraisforfaitaire
    private TableColumn nom = new TableColumn<>("nom");
    private TableColumn quantite = new TableColumn<>("quantite");
    private TableColumn montantForfait = new TableColumn<>("montant");
    private TableColumn total = new TableColumn<>("total");

    //create sub column for autrefrais
    private TableColumn date = new TableColumn<>("date");
    private TableColumn libelle = new TableColumn<>("libelle");
    private TableColumn montantAutre = new TableColumn<>("montant");

    private User user;
    private Tabs tabs;

    //main init from app
    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab2);
        tabs.setTabs(tabList);

        //set subColumn for fraisforfaitaire
        fraisforfaitaire.getColumns().addAll(nom, quantite, montantForfait, total);

        //set subColumn for autrefrais
        autrefrais.getColumns().addAll(date, libelle, montantAutre);

    }

    //init when the tab is selected
    @FXML
    void event(Event ev) {

        if (tab2.isSelected()) {



        }

    }

}
