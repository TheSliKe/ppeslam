package com.ppe;

import com.ppe.fiche.Fiche;
import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Fiche> ficheTable;

    private ObservableList<Fiche> FicheData = FXCollections.observableArrayList();

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

    }

    //init when the tab is selected
    @FXML
    void event(Event ev) {

        if (tab2.isSelected()) {

            ficheTable.getItems().clear();
            ficheTable.getItems().addAll(Context.getInstance().getDatabase().getFiche());

        }

    }

}
