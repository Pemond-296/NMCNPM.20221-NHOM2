package com.example.controller;
import com.example.model.ApartmentModel;
import com.example.model.PersonModel;
import com.example.service.impl.ApartmentService;
import com.example.service.impl.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class InformationController implements Initializable {
    private ApartmentService apartmentService = new ApartmentService();
    private PersonService personService = new PersonService();
    @FXML
    private TextField IDApartment;

    @FXML
    private TextField IDCard;

    @FXML
    private TableColumn<?, ?> apartmentId;

    @FXML
    private TableColumn<?, ?> apartmentNumber;

    @FXML
    private TableView<ApartmentModel> apartmentTable;

    @FXML
    private TableColumn<PersonModel, Date> birthDate;

    @FXML
    private TextField district;

    @FXML
    private TableColumn<ApartmentModel, String> districtName;

    @FXML
    private TableColumn<PersonModel, String> ethnic;

    @FXML
    private TableColumn<PersonModel, String> homeTown;

    @FXML
    private TableColumn<PersonModel, String> identifyNumber;

    @FXML
    private TableColumn<PersonModel, String> job;

    @FXML
    private TableColumn<ApartmentModel, String> monitorName;

    @FXML
    private TextField name;

    @FXML
    private TextField nameOwner;

    @FXML
    private TextField namePerson;

    @FXML
    private TextField numberHouse;

    @FXML
    private TableColumn<PersonModel, Long> personId;

    @FXML
    private TableColumn<PersonModel, String> personName;

    @FXML
    private TableView<PersonModel> personTable;

    @FXML
    private TableColumn<ApartmentModel, String> roadName;

    @FXML
    private Button searchApartment;

    @FXML
    private Button searchPerson;

    @FXML
    private TextField street;

    @FXML
    private TextField ward;

    @FXML
    private TableColumn<ApartmentModel, String> wardsName;

    ObservableList<ApartmentModel> observableApartmentList = FXCollections.observableArrayList(apartmentService.findAll());
    ObservableList<PersonModel> observablePersonList = FXCollections.observableArrayList(personService.findAll());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apartmentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        monitorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        apartmentNumber.setCellValueFactory(new PropertyValueFactory<>("apartmentNumber"));
        apartmentNumber.setCellValueFactory(new PropertyValueFactory<>("apartmentNumber"));
        roadName.setCellValueFactory(new PropertyValueFactory<>("roadName"));
        wardsName.setCellValueFactory(new PropertyValueFactory<>("wardsName"));
        districtName.setCellValueFactory(new PropertyValueFactory<>("districtName"));
        apartmentTable.setItems(observableApartmentList);


        personId.setCellValueFactory(new PropertyValueFactory<>("id"));
        personName.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        ethnic.setCellValueFactory(new PropertyValueFactory<>("ethnic"));
        homeTown.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        identifyNumber.setCellValueFactory(new PropertyValueFactory<>("identifyId"));
        personTable.setItems(observablePersonList);

    }

    @FXML
    void searchApartment(ActionEvent event) {
        apartmentTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    void searchPerson(ActionEvent event) {

    }
    public void showdetails(ActionEvent event) throws IOException {
        ApartmentModel model = apartmentTable.getSelectionModel().getSelectedItem();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(DetailsController.class.getResource("Details.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
