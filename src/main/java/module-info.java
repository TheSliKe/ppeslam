module com.ppe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.ppe to javafx.fxml;
    exports com.ppe;
}