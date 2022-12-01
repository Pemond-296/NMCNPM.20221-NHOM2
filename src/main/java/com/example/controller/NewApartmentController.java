package com.example.controller;

import com.example.model.ApartmentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        stage.showAndWait();
    }


    public void save(ActionEvent event) {
        ApartmentModel model = new ApartmentModel();
        model.setId(id.getText());
        model.setDistrictName(districtName.getText());
        model.setApartmentNumber(Integer.valueOf(apartmentNumber.getText()));
        model.setRoadName(roadName.getText());
        model.setWardsName(wardsName.getText());
//        model.setName();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
