package com.example.controller;

import com.example.model.DinhDanhModel;
import com.example.model.NhanKhauModel;
import com.example.service.IDinhDanhService;
import com.example.service.INhanKhauService;
import com.example.service.impl.DinhDanhService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.DateUtil;
import com.example.utils.PersonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChiTietNKController implements Initializable {
    private INhanKhauService nhanKhauService = new NhanKhauService();
    private IDinhDanhService dinhDanhService = new DinhDanhService();
    @FXML
    private AnchorPane AddPerson;
    @FXML
    private TextField BiDanh;
    @FXML
    private TextField DanToc;
    @FXML
    private TextField NguyenQuan;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnRegister;
    @FXML
    private TextField congViec;
    @FXML
    private RadioButton female;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private TextField hoTen;
    @FXML
    private RadioButton male;
    @FXML
    private DatePicker ngayDkiThuongTru;
    @FXML
    private DatePicker ngaySinh;
    @FXML
    private TextField noiDkiThuongTru;
    @FXML
    private TextField noiLamViec;
    @FXML
    private RadioButton other;
    @FXML
    private TextField soCMT;
    private final NhanKhauModel model = PersonUtil.getInstance().getNhanKhauModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hoTen.setText(model.getHoTen());
        if(model.getNgaySinh() != null) ngaySinh.setValue(DateUtil.asLocalDate(model.getNgaySinh()));
        congViec.setText(model.getCongViec());
        DanToc.setText(model.getDanToc());
        NguyenQuan.setText(model.getNguyenQuan());
        soCMT.setText(model.getSoCMT());
        noiLamViec.setText(model.getNoiLamViec());
        if(model.getNgayDkiThuongTru() != null ) ngayDkiThuongTru.setValue(DateUtil.asLocalDate(model.getNgayDkiThuongTru()));
        noiDkiThuongTru.setText(model.getNoiDkiThuongTru());
        BiDanh.setText(model.getBiDanh());

        if(Objects.equals(model.getGioiTinh(), "Nam")) {
            male.setSelected(true);
        }
        else if(Objects.equals(model.getGioiTinh(), "Nữ")) {
            female.setSelected(true);
        }
        else {
            other.setSelected(true);
        }
    }
    @FXML
    void setBtnClear(ActionEvent event) {
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

    @FXML
    void setBtnRegister(ActionEvent event) {
        if(hoTen.getText().isBlank() || ngaySinh.getValue() == null || DanToc.getText().isBlank() ||
                NguyenQuan.getText().isBlank() || soCMT.getText().isBlank() || noiDkiThuongTru.getText().isBlank() ||
                ngayDkiThuongTru.getValue() == null || genderGroup.getToggles() == null || BiDanh.getText().isBlank() ||
                congViec.getText().isBlank() || noiLamViec.getText().isBlank() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();
        }

        else {
            DinhDanhModel dinhDanhModel = new DinhDanhModel();

            dinhDanhModel.setSoCMT(soCMT.getText());

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

            Long id = this.model.getId();
            model.setId(this.model.getId());
            nhanKhauService.updateInfo(model);
            dinhDanhModel.setIdNhanKhau(id);
            dinhDanhService.update(dinhDanhModel);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cập nhật thành công");
            alert.showAndWait();

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}

