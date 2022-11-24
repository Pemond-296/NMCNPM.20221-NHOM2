package com.example.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class InformationController {
    @FXML
    private TextField IDApartment;

    @FXML
    private TextField IDCard;

    @FXML
    private TableColumn<?, ?> apartmentTable;

    @FXML
    private TextField district;

    @FXML
    private TextField name;

    @FXML
    private TextField nameOwner;

    @FXML
    private TextField namePerson;

    @FXML
    private TextField numberHouse;

    @FXML
    private TableColumn<?, ?> personTable;

    @FXML
    private Button searchApartment;

    @FXML
    private Button searchPerson;

    @FXML
    private TextField street;

    @FXML
    private TextField ward;

    @FXML
    void searchApartment(ActionEvent event) {

    }

    @FXML
    void searchPerson(ActionEvent event) {

    }
}
