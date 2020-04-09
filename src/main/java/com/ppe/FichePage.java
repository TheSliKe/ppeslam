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

    @FXML
    private Tab tab2;

    @FXML
    private TableView ficheTable;

    @FXML
    private TableColumn fraisforfaitaire;

    @FXML
    private TableColumn autrefrais;

    private TableColumn nom = new TableColumn<>("nom");
    private TableColumn quantite = new TableColumn<>("quantite");
    private TableColumn montantForfait = new TableColumn<>("montant");
    private TableColumn total = new TableColumn<>("total");

    private TableColumn date = new TableColumn<>("date");
    private TableColumn libelle = new TableColumn<>("libelle");
    private TableColumn montantAutre = new TableColumn<>("montant");

    private User user;
    private Tabs tabs;

    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab2);
        tabs.setTabs(tabList);

        fraisforfaitaire.getColumns().addAll(nom, quantite, montantForfait, total);
        autrefrais.getColumns().addAll(date, libelle, montantAutre);

    }

    @FXML
    void event(Event ev) {
        if (tab2.isSelected()) {
            System.out.println("Tab 2 is Selected");


        }
    }

}
