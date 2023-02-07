package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.service.impl.NhanKhauService;
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

public class NhanKhauController implements Initializable {
    private NhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TableColumn<?, ?> ngaySinh;
    @FXML
    private TableColumn<?, ?> danToc;
    @FXML
    private TableColumn<?, ?> nguyenQuan;
    @FXML
    private TableColumn<?, ?> soCMT;
    @FXML
    private TableColumn<?, ?> congViec;
    @FXML
    private TableColumn<?, ?> nhanKhauId;
    @FXML
    private TableColumn<?, ?> hoTen;
    @FXML
    private TableView<NhanKhauModel> nhanKhauTable;
    ObservableList<NhanKhauModel> observablePersonList = FXCollections.observableArrayList(nhanKhauService.findAll());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauId.setCellValueFactory(new PropertyValueFactory<>("id"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        congViec.setCellValueFactory(new PropertyValueFactory<>("congViec"));
        danToc.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        nguyenQuan.setCellValueFactory(new PropertyValueFactory<>("nguyenQuan"));
        soCMT.setCellValueFactory(new PropertyValueFactory<>("soCMT"));
        nhanKhauTable.setItems(observablePersonList);
    }

    public void addPerson(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("ThemNhanKhauView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        observablePersonList.clear();
        observablePersonList.addAll(nhanKhauService.findAll());
        nhanKhauTable.setItems(observablePersonList);
    }

    public void registerAbsent(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("TamVangView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
