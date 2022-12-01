package com.example.controller;

import com.example.model.PersonModel;
import com.example.service.impl.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PersonController implements Initializable {
    private PersonService personService = new PersonService();
    @FXML
    private TableColumn<?, ?> birthDate;
    @FXML
    private TableColumn<?, ?> ethnic;
    @FXML
    private TableColumn<?, ?> homeTown;
    @FXML
    private TableColumn<?, ?> identifyNumber;
    @FXML
    private TableColumn<?, ?> job;
    @FXML
    private TableColumn<?, ?> personId;
    @FXML
    private TableColumn<?, ?> personName;
    @FXML
    private TableView<PersonModel> personTable;
    ObservableList<PersonModel> observablePersonList = FXCollections.observableArrayList(personService.findAll());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personId.setCellValueFactory(new PropertyValueFactory<>("id"));
        personName.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        ethnic.setCellValueFactory(new PropertyValueFactory<>("ethnic"));
        homeTown.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        identifyNumber.setCellValueFactory(new PropertyValueFactory<>("identifyId"));
        personTable.setItems(observablePersonList);
    }

    public void addPerson(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(NewPersonController.class.getResource("NewPerson.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        observablePersonList.clear();
        observablePersonList.addAll(personService.findAll());
        personTable.setItems(observablePersonList);
    }
}
