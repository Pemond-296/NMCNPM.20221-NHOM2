package com.example.controller;

import com.example.model.GiftTableModel;
import com.example.model.HoKhauModel;
import com.example.model.NhanKhauModel;
import com.example.service.IMinhChungService;
import com.example.service.INhanKhauService;
import com.example.service.impl.MinhChungService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.PersonUtil;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuanLiMinhChungController implements Initializable {
    INhanKhauService nhanKhauService = new NhanKhauService();
    IMinhChungService minhChungService = new MinhChungService();
    @FXML
    private TableColumn<HoKhauModel, ?> ho_gia_dinh;

    @FXML
    private TableColumn<?, ?> ho_ten;

    @FXML
    private TableColumn<?, ?> minh_chung;

    @FXML
    private TableColumn<?, ?> ngay_sinh;

    @FXML
    private TableView<NhanKhauModel> nhan_khauTable;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TextField tim_kiemText;


    @FXML
    void tim_kiem(ActionEvent event) {
        List<NhanKhauModel> models = nhanKhauService.findAll();
        String keyword = tim_kiemText.getText();
        if(keyword.isEmpty()) {
            observableList.clear();
            observableList.addAll(models);
            nhan_khauTable.refresh();
            return;
        }
        observableList.clear();
        keyword = keyword.toLowerCase();
        for(NhanKhauModel model : models){
            if(model.getHoTen().toLowerCase().contains(keyword)){
                observableList.add(model);
            }
        }
        nhan_khauTable.refresh();
    }

    List<NhanKhauModel> nhanKhauModelList = nhanKhauService.findByAge();
    ObservableList<NhanKhauModel> observableList = FXCollections.observableArrayList(getMinhChung());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stt.setCellValueFactory(new PropertyValueFactory<>("id"));
        ho_ten.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngay_sinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        ho_gia_dinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        minh_chung.setCellValueFactory(new PropertyValueFactory<>("minhChung"));
        nhan_khauTable.setItems(observableList);
    }

    List<NhanKhauModel> getMinhChung(){

        for (NhanKhauModel model : nhanKhauModelList){

            if(minhChungService.isMinhChung(model) == 1){
                model.setMinhChung("Đã có");
            }
            else model.setMinhChung("Chưa có");

        }
        return nhanKhauModelList;

    }
    @FXML
    void tao_minh_chung(ActionEvent event) throws IOException {
        PersonUtil.getInstance().setMinhChung(nhan_khauTable.getSelectionModel().getSelectedItem());

        if (PersonUtil.getInstance().getMinhchung() != null) {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("TaoMinhChung.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            observableList.clear();
            observableList.addAll(getMinhChung());
            nhan_khauTable.setItems(observableList);
        }
        else{
            System.out.println("Vui long click vao nguoi muon tao minh chung");
        }
    }

}
