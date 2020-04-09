package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.scene.chart.PieChart;

public class Context {



    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private User user = new User();
    public User getUser() {
        return user;
    }

    private Tabs tabs = new Tabs();
    public Tabs getTabs() {
        return tabs;
    }

    private Database database = new Database();
    public Database getDatabase(){return database;}

}