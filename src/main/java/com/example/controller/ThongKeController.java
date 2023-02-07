package com.example.controller;
import com.example.model.ThongKeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {


        @FXML
        private Button chon_dip;

        @FXML
        private TableColumn<?, ?> nam;

        @FXML
        private TableColumn<?, ?> qua;

        @FXML
        private TableColumn<?, ?> stt;

        @FXML
        private TableColumn<?, ?> ten_chu_ho;

        @FXML
        private TableView<ThongKeModel> thong_keTable;

        @FXML
        private TableColumn<?, ?> tien;

        @FXML
        private Label tong_tien;

        @FXML
        void chon_dipEvent(ActionEvent event) {

        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
