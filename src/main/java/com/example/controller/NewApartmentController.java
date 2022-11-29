package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NewApartmentController {
    @FXML
    private TextField id;
    @FXML
    private TextField districtName;
    @FXML
    private TextField apartmentNumber;
    @FXML
    private TextField roadName;
    @FXML
    private TextField wardsName;

    public void selectMonitor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NewApartmentController.class.getResource("PersonTable.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
