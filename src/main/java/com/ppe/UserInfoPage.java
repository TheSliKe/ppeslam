package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import java.util.List;

public class UserInfoPage {

    //get this tab from FXML
    @FXML
    private Tab tab3;
    //get ListView from FXML
    @FXML
    private ListView listView;

    //local instance for user and tabs
    private User user;
    private Tabs tabs;

    //main init from app
    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab3);
        tabs.setTabs(tabList);

    }

    //init when the tab is selected
    @FXML
    void event(Event ev) {

        if (tab3.isSelected()) {

            setListView();

        }

    }

    //method to set user info in listview
    private void setListView() {

        listView.getItems().clear();

        listView.getItems().add(user.getName());
        listView.getItems().add(user.getLastname());
        listView.getItems().add(user.getAdresse());
        listView.getItems().add(user.getBirthdate());

    }

}
