package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.service.IApartmentService;
import com.example.service.impl.ApartmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private final IApartmentService apartmentService = new ApartmentService();

    @FXML
    private TableView<ApartmentModel> table;
    @FXML
    private TableColumn<ApartmentModel, String> name;
    @FXML
    private TableColumn<ApartmentModel, Integer> apartmentNumber;
    @FXML
    private TableColumn<ApartmentModel, String> roadName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        apartmentNumber.setCellValueFactory(new PropertyValueFactory<>("apartmentNumber"));
        roadName.setCellValueFactory(new PropertyValueFactory<>("roadName"));
        table.setItems(observableList);
    }

    ObservableList<ApartmentModel> observableList = FXCollections.observableArrayList(apartmentService.findAll());
}
