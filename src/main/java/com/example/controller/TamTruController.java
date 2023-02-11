package com.example.controller;

import com.example.model.DinhDanhModel;
import com.example.model.NhanKhauModel;
import com.example.model.TamTruModel;
import com.example.service.IDinhDanhService;
import com.example.service.INhanKhauService;
import com.example.service.ITamTruService;
import com.example.service.impl.DinhDanhService;
import com.example.service.impl.NhanKhauService;
import com.example.service.impl.TamTruService;
import com.example.utils.DateUtil;
import com.example.utils.PersonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TamTruController {
    private INhanKhauService nhanKhauService = new NhanKhauService();
    private ITamTruService tamTruService = new TamTruService();
    private IDinhDanhService dinhDanhService = new DinhDanhService();
    @FXML
    private DatePicker denNgay;
    @FXML
    private TextField hoTen;
    @FXML
    private TextArea lyDo;
    @FXML
    private TextField queQuan;
    @FXML
    private TextField soCMT;
    @FXML
    private DatePicker tuNgay;
    @FXML
    private DatePicker ngaySinh;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton other;
    @FXML
    private ToggleGroup genderGroup;

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void submit(ActionEvent event) {
        if(hoTen.getText().isBlank() || soCMT.getText().isBlank() || lyDo.getText().isBlank() ||
            tuNgay.getValue() == null || denNgay.getValue() == null || queQuan.getText().isBlank() ||
            genderGroup.getSelectedToggle() == null || ngaySinh.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
        }

        else {
            NhanKhauModel nhanKhauModel = new NhanKhauModel();
            DinhDanhModel dinhDanhModel = new DinhDanhModel();
            TamTruModel tamTruModel = new TamTruModel();

            nhanKhauModel.setHoTen(hoTen.getText());
            nhanKhauModel.setNguyenQuan(queQuan.getText());
            nhanKhauModel.setNgaySinh(DateUtil.asDate(ngaySinh.getValue()));
            if(male.isSelected()) nhanKhauModel.setGioiTinh(male.getText());
            else if(female.isSelected()) nhanKhauModel.setGioiTinh(female.getText());
            else nhanKhauModel.setGioiTinh(other.getText());
            Long id = nhanKhauService.save(nhanKhauModel);

            dinhDanhModel.setSoCMT(soCMT.getText());
            dinhDanhModel.setIdNhanKhau(id);
            dinhDanhService.save(dinhDanhModel);

            tamTruModel.setIdNhanKhau(id);
            tamTruModel.setTuNgay(DateUtil.asDate(tuNgay.getValue()));
            tamTruModel.setDenNgay(DateUtil.asDate(denNgay.getValue()));
            tamTruModel.setLyDo(lyDo.getText());

            tamTruService.save(tamTruModel);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Khai báo thành công");
            alert.showAndWait();

            nhanKhauModel.setSoCMT(dinhDanhModel.getSoCMT());
            nhanKhauModel.setId(id);
            PersonUtil.getInstance().setTamTru(nhanKhauModel);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
