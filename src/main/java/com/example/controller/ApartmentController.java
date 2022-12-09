package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.service.impl.ApartmentService;
import com.example.utils.ApartmentUtil;
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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ApartmentController implements Initializable {
    private ApartmentService apartmentService = new ApartmentService();
    @FXML
    private TableColumn<?, ?> apartmentId;
    @FXML
    private TableColumn<?, ?> apartmentNumber;
    @FXML
    private TableView<ApartmentModel> apartmentTable;
    @FXML
    private TableColumn<?, ?> districtName;
    @FXML
    private TableColumn<?, ?> monitorName;
    @FXML
    private TableColumn<?, ?> roadName;
    @FXML
    private TableColumn<?, ?> wardsName;

    List<ApartmentModel> models = apartmentService.findAll();

    ObservableList<ApartmentModel> observableApartmentList = FXCollections.observableArrayList(models);

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
    }

    public void newApartment(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(NewApartmentController.class.getResource("NewApartment.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();

        observableApartmentList.clear();
        observableApartmentList.addAll(ApartmentUtil.getInstance().getModels());
        apartmentTable.setItems(observableApartmentList);
    }
}
