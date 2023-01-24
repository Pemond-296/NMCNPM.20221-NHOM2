package com.example.controller;

import com.example.model.UserModel;
import com.example.service.IHoKhauService;
import com.example.service.impl.HoKhauService;
import com.example.utils.SessionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel model = SessionUtil.getInstance().getData();

        loginLabel.setText("Logged in as:\n" + model.getFullName());
    }

    @FXML
    void quanLiDip(ActionEvent event) {
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
}
