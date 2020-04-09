package com.ppe;

import com.ppe.tabpane.Tabs;
import com.ppe.user.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
import java.util.List;

public class LoginPage {

    @FXML
    private Tab tab1;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    private User user;
    private Tabs tabs;

    @FXML
    public void initialize() {

        user = Context.getInstance().getUser();
        tabs = Context.getInstance().getTabs();

        List<Tab> tabList = tabs.getTabs();
        tabList.add(tab1);
        tabs.setTabs(tabList);

    }

    @FXML
    private void submit(){

        String username = this.username.getText();
        String password = this.password.getText();

        if (Context.getInstance().getDatabase().login(username, password)){
            user.setConnected(true);
            user.setUsername(username);
            user.setPassword(password);
            Context.getInstance().getDatabase().infoUser();

            updateDisplay();
        } else {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("Nom d'utilisateur ou Mot de passe incorrect"));
            Button ok = new Button("Ok");
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                   dialog.hide();
                }
            });
            dialogVbox.getChildren().add(ok);
            Scene dialogScene = new Scene(dialogVbox);
            dialog.setScene(dialogScene);
            dialog.show();
        }

    }

    @FXML
    private void updateDisplay(){

        tabs.getTabPane().getTabs().remove(tabs.getTabs().get(0));
        tabs.getTabPane().getTabs().add(tabs.getTabs().get(1));
        tabs.getTabPane().getTabs().add(tabs.getTabs().get(2));
        tabs.getTabPane().getTabs().add(tabs.getTabs().get(3));

    }

}
