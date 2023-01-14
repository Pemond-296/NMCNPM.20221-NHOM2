package com.example.controller;


import com.example.model.GiftTableModel;
import com.example.service.IGiftTableService;
import com.example.service.impl.GiftTableService;
import com.example.utils.DipUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QuanLiTraoThuongController implements Initializable {
    private IGiftTableService giftTableService = new GiftTableService();


    @FXML
    private Button BtimKiem;

    @FXML
    private TableColumn<?, ?> ChoTen;

    @FXML
    private TableColumn<?, ?> Cqua;

    @FXML
    private TableColumn<?, ?> CsoLuong;

    @FXML
    private TableColumn<?, ?> Cstt;

    @FXML
    private TableColumn<?, ?> Cthanhtich;

    @FXML
    private TableColumn<?, ?> Cthoigian;

    @FXML
    private TableColumn<?, ?> Ctien;

    @FXML
    private TableColumn<?, ?> CtrangThai;

    @FXML
    private TextField Ften;

    @FXML
    private TableView<GiftTableModel> table;
    List<GiftTableModel> giftTableModelList = giftTableService.findByDip(DipUtil.getInstance().getData());
    ObservableList<GiftTableModel> observableList = FXCollections.observableArrayList(giftTableModelList);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Cstt.setCellValueFactory(new PropertyValueFactory<>("so_thu_tu"));
        Cqua.setCellValueFactory(new PropertyValueFactory<>("ten_phan_qua"));
        ChoTen.setCellValueFactory(new PropertyValueFactory<>("ten_nhan_khau"));
        CsoLuong.setCellValueFactory(new PropertyValueFactory<>("so_luong"));
        Cthoigian.setCellValueFactory(new PropertyValueFactory<>("ngay_thang"));
        Cthanhtich.setCellValueFactory(new PropertyValueFactory<>("ten_thanh_tich"));
        table.setItems(observableList);
    }

    @FXML
    void EthayDoi(ActionEvent event) {

    }

    @FXML
    void Ethem(ActionEvent event) {

    }

    @FXML
    void Ethoat(ActionEvent event) {

    }

    @FXML
    void EthongKe(ActionEvent event) {

    }

    @FXML
    void EtimKiem(ActionEvent event) {

    }

    @FXML
    void Exoa(ActionEvent event) {

    }

}
