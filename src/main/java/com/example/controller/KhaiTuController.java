package com.example.controller;

import com.example.dao.IKhaiTuDAO;
import com.example.dao.impl.KhaiTuDAO;
import com.example.model.KhaiTuModel;
import com.example.model.NhanKhauModel;
import com.example.service.IKhaiTuService;
import com.example.service.impl.KhaiTuService;
import com.example.utils.DateUtil;
import com.example.utils.PersonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KhaiTuController implements Initializable {

    @FXML
    private TextField hoTen;

    @FXML
    private TextField id;

    @FXML
    private DatePicker ngayKhaiTu;

    @FXML
    private DatePicker ngayQuaDoi;

    @FXML
    private TextArea nguyenNhan;
    private IKhaiTuService khaiTuService = new KhaiTuService();
    NhanKhauModel model = PersonUtil.getInstance().getKhaiTu();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hoTen.setText(model.getHoTen());
    }

    @FXML
    void exit(ActionEvent event) {
//        PersonUtil.getInstance().setKhaiTu(null);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void submit(ActionEvent event) {
        if(id.getText().isBlank() || ngayKhaiTu.getValue() == null ||
                ngayQuaDoi.getValue() == null || nguyenNhan.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();
        }

        else {
            KhaiTuModel khaiTuModel = new KhaiTuModel();

            khaiTuModel.setId(Long.valueOf(id.getText()));
            khaiTuModel.setIdNhanKhau(model.getId());
            khaiTuModel.setNguoiKhaiTu(model.getHoTen());
            khaiTuModel.setNgayKhaiTu(DateUtil.asDate(ngayKhaiTu.getValue()));
            khaiTuModel.setNgayQuaDoi(DateUtil.asDate(ngayQuaDoi.getValue()));
            khaiTuModel.setNguyenNhan(nguyenNhan.getText());

            khaiTuService.save(khaiTuModel);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Khai tử thành công");
            alert.showAndWait();

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}

