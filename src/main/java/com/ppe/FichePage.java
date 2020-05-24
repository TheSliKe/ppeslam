package com.ppe;

import com.ppe.fiche.Fiche;
import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class FichePage {

    //get this tab
    @FXML
    private Tab tab2;

    //get tableview from FXML
    @FXML
    private TableView<Fiche> ficheTable;

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

        ficheTable.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0) {

                try {

                    Tab t = FXMLLoader.load(this.getClass().getResource("FicheTab.fxml"));
                    t.setId(ficheTable.getSelectionModel().getSelectedItem().getMatricule());
                    t.setText("Fiche numero : " + ficheTable.getSelectionModel().getSelectedItem().getMatricule());

                    tabs.getTabPane().getTabs().addAll(t);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println();

            }

        });

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
