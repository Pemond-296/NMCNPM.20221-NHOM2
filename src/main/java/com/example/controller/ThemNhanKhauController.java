package com.example.controller;

import com.example.model.DiaDiemModel;
import com.example.model.DinhDanhModel;
import com.example.model.NhanKhauModel;
import com.example.service.IDiaDiemService;
import com.example.service.IDinhDanhService;
import com.example.service.INhanKhauService;
import com.example.service.impl.DiaDiemService;
import com.example.service.impl.DinhDanhService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.DateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.ParseException;

public class ThemNhanKhauController {
    private INhanKhauService nhanKhauService = new NhanKhauService();
    private IDinhDanhService dinhDanhService = new DinhDanhService();
    private IDiaDiemService diaDiemService = new DiaDiemService();
    @FXML
    private AnchorPane AddPerson;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegister;

    @FXML
    private DatePicker ngaySinh;

    @FXML
    private TextField DanToc;

    @FXML
    private RadioButton female;

    @FXML
    private TextField hoTen;

    @FXML
    private TextField NguyenQuan;

    @FXML
    private TextField soCMT;

    @FXML
    private TextField congViec;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton other;
    @FXML
    private TextField noiLamViec;
    @FXML
    private TextField noiDkiThuongTru;
    @FXML
    public DatePicker ngayDkiThuongTru;

    @FXML
    private TextField BiDanh;
    @FXML
    private ToggleGroup genderGroup;

    public void setBtnClear(ActionEvent event) {
        hoTen.clear();
        ngaySinh.getEditor().clear();
        congViec.clear();
        DanToc.clear();
        NguyenQuan.clear();
        soCMT.clear();
        noiLamViec.clear();
        noiDkiThuongTru.clear();
        ngayDkiThuongTru.getEditor().clear();
        BiDanh.clear();
    }
    public void setBtnRegister(ActionEvent event) throws ParseException {
        NhanKhauModel model = new NhanKhauModel();
        DiaDiemModel diaDiemModel = new DiaDiemModel();
        DinhDanhModel dinhDanhModel = new DinhDanhModel();

        dinhDanhModel.setSoCMT(soCMT.getText());

        model.setLocationModel(diaDiemModel);
        model.setIdentifierModel(dinhDanhModel);
        model.setHoTen(hoTen.getText());
        model.setDanToc(DanToc.getText());
        model.setNgaySinh(DateUtil.asDate(ngaySinh.getValue()));
        model.setNguyenQuan(NguyenQuan.getText());
        model.setBiDanh(BiDanh.getText());
        model.setNoiDkiThuongTru(noiDkiThuongTru.getText());
        model.setNgayDkiThuongTru(DateUtil.asDate(ngayDkiThuongTru.getValue()));


        if(male.isSelected()) model.setGioiTinh(male.getText());
        else if(female.isSelected()) model.setGioiTinh(female.getText());
        else model.setGioiTinh(other.getText());

        model.setCongViec(congViec.getText());
        model.setNoiLamViec(noiLamViec.getText());

        Long id = nhanKhauService.save(model);
        diaDiemModel.setIdNhanKhau(id);
        dinhDanhModel.setIdNhanKhau(id);
        diaDiemService.save(diaDiemModel);
        dinhDanhService.save(dinhDanhModel);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

}
