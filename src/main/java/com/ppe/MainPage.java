package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import java.util.List;

public class MainPage {

    //get tabPane from FXML
    @FXML
    private TabPane tablePane;

    //create a local user / tabs and tab list
    private User user;
    private Tabs tabs;
    private List<Tab> tabList;

    @FXML
    public void initialize() {

        //set local user and tabs
        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();
        tabs.setTabPane(tablePane);
        tabList = tabs.getTabs();


        //remove tab for log-in
        tablePane.getTabs().remove(tabList.get(1));
        tablePane.getTabs().remove(tabList.get(2));
        tablePane.getTabs().remove(tabList.get(3));


    }


    //method for to disconnect current user and redirect to log-in page
    public void reLog(){

        user.setConnected(false);

        //remove all tabs and add login tab
        tablePane.getTabs().add(tabList.get(0));
        tablePane.getTabs().remove(tabList.get(1));
        tablePane.getTabs().remove(tabList.get(2));
        tablePane.getTabs().remove(tabList.get(3));

    }

}
