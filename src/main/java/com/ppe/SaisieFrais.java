package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

import java.util.List;

public class SaisieFrais {

    //get this tab
    @FXML
    private Tab tab4;

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

    }

    //init when the tab is selected
    @FXML
    void event(Event ev) {

        if (tab4.isSelected()) {



        }

    }


}
