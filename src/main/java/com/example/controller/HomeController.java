package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.model.UserModel;
import com.example.service.IApartmentService;
import com.example.service.impl.ApartmentService;
import com.example.utils.SessionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

        UserModel model = SessionUtil.getInstance().getData();

        loginLabel.setText("Logged in as:\n" + model.getFullName());
    }

    ObservableList<ApartmentModel> observableList = FXCollections.observableArrayList(apartmentService.findAll());

    public void addPersonInfo(MouseEvent mouseEvent) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(AddPersonController.class.getResource("AddPerson.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.setVisible(false);
        application.getChildren().add(rootChild);

    }
}
