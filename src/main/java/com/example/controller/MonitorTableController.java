package com.example.controller;

import com.example.model.PersonModel;
import com.example.service.impl.PersonService;
import com.example.utils.PersonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class MonitorTableController implements Initializable {
    private PersonService personService = new PersonService();
    @FXML
    private TableView<PersonModel> personTable;
    @FXML
    private TableColumn<PersonModel, Date> birthDate;

    @FXML
    private TableColumn<PersonModel, String> ethnic;

    @FXML
    private TableColumn<PersonModel, String> homeTown;

    @FXML
    private TableColumn<PersonModel, String> identifyNumber;

    @FXML
    private TableColumn<PersonModel, String> job;

    @FXML
    private TableColumn<PersonModel, Long> personId;

    @FXML
    private TableColumn<PersonModel, String> personName;

    ObservableList<PersonModel> observablePersonList = FXCollections.observableArrayList(personService.findMonitor());
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

    public void save(ActionEvent event) {
        try {
            PersonModel model = personTable.getSelectionModel().getSelectedItem();
            PersonUtil.getInstance().setMonitor(model);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Vui lòng chọn lại");
            alert.showAndWait();
            alert.setHeaderText(e.getMessage());
        }
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
