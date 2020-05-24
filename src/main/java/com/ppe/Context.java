package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.scene.Scene;

public class Context {

    //main Context
    private final static Context instance = new Context();
    //getter for Context
    public static Context getInstance() {
        return instance;
    }

    //Global object
    private User user = new User();
    private Tabs tabs = new Tabs();
    private Database database = new Database();


    //-----------------------------------------getters for all object---------------------------------------------------
    public User getUser() {
        return user;
    }
    public Tabs getTabs() {
        return tabs;
    }
    public Database getDatabase(){return database;}

}