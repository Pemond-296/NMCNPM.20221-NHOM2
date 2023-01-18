module com.example {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example to javafx.fxml;
    opens com.example.controller;
    opens com.example.model to javafx.base;
    exports com.example;
    exports com.example.controller;
    requires java.sql;
    requires java.desktop;

}