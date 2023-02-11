package com.example.controller;

import com.example.model.DiaDiemModel;
import com.example.service.IDiaDiemService;
import com.example.service.impl.DiaDiemService;
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

public class ChuyenDiController implements Initializable {
    private IDiaDiemService diaDiemService = new DiaDiemService();
    @FXML
    private TextArea ghiChu;
    @FXML
    private TextField hoTen;
    @FXML
    private DatePicker ngayChuyen;
    @FXML
    private TextField noiChuyen;
    @FXML
    private TextField soCMT;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hoTen.setText(PersonUtil.getInstance().getChuyenDi().getHoTen());
        soCMT.setText(PersonUtil.getInstance().getChuyenDi().getSoCMT());
    }
    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void submit(ActionEvent event) {
        if(noiChuyen.getText().isBlank() || ngayChuyen.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
        }

        else {
            DiaDiemModel diaDiemModel = new DiaDiemModel();
            diaDiemModel.setIdNhanKhau(PersonUtil.getInstance().getChuyenDi().getId());
            diaDiemModel.setNoiChuyen(noiChuyen.getText());
            diaDiemModel.setNgayChuyen(DateUtil.asDate(ngayChuyen.getValue()));
            diaDiemModel.setGhiChu(ghiChu.getText());

            diaDiemService.save(diaDiemModel);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Khai báo thành công");
            alert.showAndWait();

            exit(event);
        }
    }
}
