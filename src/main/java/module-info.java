module com.ppe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.ppe to javafx.fxml;
    opens com.ppe.fiche to javafx.base;
    opens com.ppe.fiche.FraisForfaitaire to javafx.base;
    exports com.ppe;
}