package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.service.impl.NhanKhauService;
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

public class ChuHoTableController implements Initializable {
    private NhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TableView<NhanKhauModel> nhanKhauTable;
    @FXML
    private TableColumn<NhanKhauModel, Date> ngaySinh;

    @FXML
    private TableColumn<NhanKhauModel, String> danToc;

    @FXML
    private TableColumn<NhanKhauModel, String> nguyenQuan;

    @FXML
    private TableColumn<NhanKhauModel, String> soCMT;

    @FXML
    private TableColumn<NhanKhauModel, String> congViec;

    @FXML
    private TableColumn<NhanKhauModel, Long> idNhanKhau;

    @FXML
    private TableColumn<NhanKhauModel, String> hoTen;

    ObservableList<NhanKhauModel> danhSachChuHo = FXCollections.observableArrayList(nhanKhauService.findMonitor());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idNhanKhau.setCellValueFactory(new PropertyValueFactory<>("id"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        congViec.setCellValueFactory(new PropertyValueFactory<>("congViec"));
        danToc.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        nguyenQuan.setCellValueFactory(new PropertyValueFactory<>("nguyenQuan"));
        soCMT.setCellValueFactory(new PropertyValueFactory<>("soCMT"));

        nhanKhauTable.setItems(danhSachChuHo);
    }

    public void save(ActionEvent event) {
        NhanKhauModel model = nhanKhauTable.getSelectionModel().getSelectedItem();
        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Bạn chưa chọn chủ hộ");
            alert.setContentText("Vui lòng chọn lại");
            alert.showAndWait();
        }

        else {
            PersonUtil.getInstance().setMonitor(model);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
