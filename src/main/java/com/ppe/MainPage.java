package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    @FXML
    private TabPane tablePane;

    private User user;
    private Tabs tabs;
    private List<Tab> tabList;

    @FXML
    public void initialize() {


        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        tabs.setTabPane(tablePane);
        tabList = tabs.getTabs();

        tablePane.getTabs().remove(tabList.get(1));
        tablePane.getTabs().remove(tabList.get(2));


    }

    public void reLog(){

        user.setConnected(false);
        tablePane.getTabs().add(tabList.get(0));
        tablePane.getTabs().remove(tabList.get(1));
        tablePane.getTabs().remove(tabList.get(2));


    }


}
