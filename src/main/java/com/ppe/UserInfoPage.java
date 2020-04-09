package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.sql.*;
import java.util.List;
import java.util.Set;

public class UserInfoPage {

    @FXML
    private ListView listView;

    @FXML
    private Tab tab3;

    private User user;
    private Tabs tabs;

    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab3);
        tabs.setTabs(tabList);

    }

    @FXML
    void event(Event ev) {
        if (tab3.isSelected()) {
            System.out.println("Tab 3 is Selected");

            setListView();
        }
    }

    private void setListView() {
        listView.getItems().add(user.getName());
        listView.getItems().add(user.getLastname());
        listView.getItems().add(user.getAdresse());
        listView.getItems().add(user.getBirthdate());
    }

}
