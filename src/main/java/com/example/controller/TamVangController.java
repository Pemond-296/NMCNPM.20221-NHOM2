package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.model.TamVangModel;
import com.example.service.INhanKhauService;
import com.example.service.ITamVangService;
import com.example.service.impl.NhanKhauService;
import com.example.service.impl.TamVangService;
import com.example.utils.DateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Objects;

public class TamVangController {
    private INhanKhauService nhanKhauService = new NhanKhauService();
    private ITamVangService tamVangService = new TamVangService();
    @FXML
    private TextField noiTamTru;

    @FXML
    private ImageView checkImg;

    @FXML
    private DatePicker ngayVe;

    @FXML
    private DatePicker ngayDi;

    @FXML
    private TextField soCMT;

    @FXML
    private TextField tenChuHo;

    @FXML
    private TextArea ghiChu;
    private Long nhanKhauId;

    public void check(ActionEvent event) {
        List<NhanKhauModel> modelList = nhanKhauService.findAll();

        if(soCMT.getText().isEmpty()) {
            checkImg.setImage(new Image(Objects.requireNonNull(TamVangController.class.getResourceAsStream("images/unchecked.png"))));
            tenChuHo.clear();
            noiTamTru.clear();
            return;
        }

        for(NhanKhauModel model : modelList) {
            if(model.getIdentifierModel().getSoCMT().trim().equals(soCMT.getText())) {
                checkImg.setImage(new Image(Objects.requireNonNull(TamVangController.class.getResourceAsStream("images/accept.png"))));
                tenChuHo.setText(model.getHoTen());
                noiTamTru.setText(model.getNguyenQuan());
                nhanKhauId = model.getId();
                return;
            }
        }

        checkImg.setImage(new Image(Objects.requireNonNull(TamVangController.class.getResourceAsStream("images/failed.png"))));
        tenChuHo.clear();
        noiTamTru.clear();
    }

    public void submit(ActionEvent event) {
        if(noiTamTru.getText().isEmpty() || ngayDi.getEditor().getText().isEmpty() ||
                ngayVe.getEditor().getText().isEmpty() || ghiChu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
        }
        else {
            if(ngayVe.getValue().compareTo(ngayDi.getValue()) <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ngày không hợp lệ");
                alert.setContentText("Vui lòng chọn lại");
                alert.showAndWait();
            }

            else {
                TamVangModel model = new TamVangModel();
                model.setIdNhanKhau(nhanKhauId);
                model.setNgayDi(DateUtil.asDate(ngayDi.getValue()));
                model.setNgayVe(DateUtil.asDate(ngayVe.getValue()));
                model.setGhiChu(ghiChu.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Khai báo thành công");
                alert.showAndWait();

                tamVangService.save(model);
            }
        }
    }
}
