package com.example.controller;

import com.example.model.UserModel;
import com.example.service.IHoKhauService;
import com.example.service.INhanKhauService;
import com.example.service.impl.HoKhauService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.SessionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TrangChuController implements Initializable {
    private final IHoKhauService apartmentService = new HoKhauService();
    @FXML
    private AnchorPane application;
    @FXML
    private Label loginLabel;
    @FXML
    private Label soLuongHoKhau;
    @FXML
    private Label soLuongNhanKhau;
    @FXML
    private Label soLuongTamTru;
    @FXML
    private Label soLuongTamVang;
    private IHoKhauService hoKhauService = new HoKhauService();
    private INhanKhauService nhanKhauService = new NhanKhauService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel model = SessionUtil.getInstance().getData();

        loginLabel.setText("Logged in as:\n" + model.getFullName());
        soLuongHoKhau.setText(String.valueOf(hoKhauService.count()));
        soLuongNhanKhau.setText(String.valueOf(nhanKhauService.count()));
    }

    @FXML
    public void quanLiDip(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("QuanLiDip.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }

    public void xemThongTinNhanKhau(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("NhanKhauView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }

    public void xemThongTinHoKhau(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("HoKhauView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }

    public void trangChu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(TrangChuController.class.getResource("TrangChuView.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(TrangChuController.class.getResource("TrangChu.css")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public void xemThongKe(ActionEvent event) {
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("ThongKeview.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        application.getChildren().add(rootChild);
    }
}
