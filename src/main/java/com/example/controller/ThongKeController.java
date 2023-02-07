package com.example.controller;

import com.example.model.EventGiftModel;
import com.example.model.HoKhauModel;
import com.example.model.ThongKeModel;
import com.example.service.IThongKeService;
import com.example.service.impl.ThongKeService;
import com.example.utils.DipUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {

        private IThongKeService thongKeService = new ThongKeService();

        @FXML
        private Label Tong_Tien;

        @FXML
        private Label Tong_Qua;

        @FXML
        private TableColumn<?, ?> STT;

        @FXML
        private TextField TenDip;

        @FXML
        private TableColumn<?, ?> Ten_Chu_Ho;

        @FXML
        private TableColumn<?, ?> Tien;

        @FXML
        private TableColumn<?, ?> So_Luong;

        @FXML
        private TableColumn<?, ?> Qua;

        @FXML
        private TableView<ThongKeModel> ThongKeTable;


        ObservableList<ThongKeModel> DanhSachThongKe = FXCollections.observableArrayList(getSTT());

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                STT.setCellValueFactory(new PropertyValueFactory<>("stt"));
                Ten_Chu_Ho.setCellValueFactory(new PropertyValueFactory<>("ten_chu_ho"));
                Qua.setCellValueFactory(new PropertyValueFactory<>("phan_qua"));
                So_Luong.setCellValueFactory(new PropertyValueFactory<>("so_luong"));
                Tien.setCellValueFactory(new PropertyValueFactory<>("tien"));

                ThongKeTable.setItems(DanhSachThongKe);
                Tong_Tien.setText(Tien());

        }
        public String Tien(){
                Integer sum = 0;
                for(ThongKeModel thongKeModel : DanhSachThongKe){
                        sum+= thongKeModel.getTien();
                }
                return sum.toString();
        }

        public List<ThongKeModel> getSTT(){
                List<ThongKeModel> models = thongKeService.findByDip(DipUtil.getInstance().getData());
                for(int i = 0; i < models.size(); i++){
                        models.get(i).setStt(i+1);
                }
                return models;
        }


}