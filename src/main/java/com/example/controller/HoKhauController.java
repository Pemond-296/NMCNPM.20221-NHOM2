package com.example.controller;

import com.example.model.HoKhauModel;
import com.example.model.NhanKhauModel;
import com.example.service.impl.HoKhauService;
import com.example.utils.ApartmentUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class HoKhauController implements Initializable {
    private HoKhauService hoKhauService = new HoKhauService();
    @FXML
    private TableColumn<?, ?> idHoKhau;
    @FXML
    private TableColumn<?, ?> soNha;
    @FXML
    private TableView<HoKhauModel> hoKhauTable;
    @FXML
    private TableColumn<?, ?> quanHuyen;
    @FXML
    private TableColumn<?, ?> tenChuHo;
    @FXML
    private TableColumn<?, ?> tenDuong;
    @FXML
    private TableColumn<?, ?> phuongXa;
    @FXML
    private TextField searchBar;

    List<HoKhauModel> models = hoKhauService.findAll();

    ObservableList<HoKhauModel> observableApartmentList = FXCollections.observableArrayList(models);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idHoKhau.setCellValueFactory(new PropertyValueFactory<>("id"));
        tenChuHo.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
        soNha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        tenDuong.setCellValueFactory(new PropertyValueFactory<>("tenDuong"));
        phuongXa.setCellValueFactory(new PropertyValueFactory<>("phuongXa"));
        quanHuyen.setCellValueFactory(new PropertyValueFactory<>("quanHuyen"));
        hoKhauTable.setItems(observableApartmentList);
    }

    public void newApartment(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThemHoKhauView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();

        observableApartmentList.clear();
        observableApartmentList.addAll(ApartmentUtil.getInstance().getModels());
        hoKhauTable.setItems(observableApartmentList);
    }

    public void TachKhau(ActionEvent event) throws IOException {
        HoKhauModel model = hoKhauTable.getSelectionModel().getSelectedItem();

        if(model != null) {
            ApartmentUtil.getInstance().setApartmentModel(model);

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(TachKhauController.class.getResource("TachKhau.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();

            if(ApartmentUtil.getInstance().getNewApartmentModel() != null) {
                hoKhauTable.getItems().add(ApartmentUtil.getInstance().getNewApartmentModel());
                hoKhauTable.refresh();
                ApartmentUtil.getInstance().setNewApartmentModel(null);
            }

        }


        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn hộ khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

    }

    public void timKiem(ActionEvent event) {
        String keyword = searchBar.getText();
        List<HoKhauModel> models = hoKhauService.findAll();
        if(keyword.isEmpty()) {
            observableApartmentList.clear();
            observableApartmentList.addAll(models);
            hoKhauTable.refresh();
            return;
        }

        observableApartmentList.clear();

        for(HoKhauModel model : models) {
            if(model.getId().contains(keyword)) {
                observableApartmentList.add(model);
            }
        }

        hoKhauTable.refresh();
    }
}
