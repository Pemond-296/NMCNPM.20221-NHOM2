package com.example.controller;

import com.example.model.UserModel;
import com.example.service.IApartmentService;
import com.example.service.impl.ApartmentService;
import com.example.utils.SessionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private final IApartmentService apartmentService = new ApartmentService();
    @FXML
    private AnchorPane application;
    @FXML
    private Label loginLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel model = SessionUtil.getInstance().getData();

        loginLabel.setText("Logged in as:\n" + model.getFullName());
    }


    public void showInfo(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(NewPersonController.class.getResource("Information.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }

    public void showPersonInfo(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(NewPersonController.class.getResource("Person.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }

    public void showApartmentInfo(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(NewPersonController.class.getResource("Apartment.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }
}
