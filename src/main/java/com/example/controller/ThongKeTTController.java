package com.example.controller;

import com.example.model.ThongKeTTModel;
import com.example.service.IThongKeTTService;
import com.example.service.impl.ThongKeTTService;
import com.example.utils.DipUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeTTController implements Initializable {

        private IThongKeTTService thongKeService = new ThongKeTTService();

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
        private TableView<ThongKeTTModel> ThongKeTable;


        @FXML
        private Label content;

        ObservableList<ThongKeTTModel> DanhSachThongKe = FXCollections.observableArrayList(getSTT());

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                content.setText("THỐNG KÊ DIP: " + DipUtil.getInstance().getData().getNameEvent().toUpperCase());
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
                for(ThongKeTTModel thongKeTTModel : DanhSachThongKe){
                        sum+= thongKeTTModel.getTien();
                }
                return sum.toString() + " Đồng";
        }

        public List<ThongKeTTModel> getSTT(){
                List<ThongKeTTModel> models = thongKeService.findByDip(DipUtil.getInstance().getData());
                for(int i = 0; i < models.size(); i++){
                        models.get(i).setStt(i+1);
                }
                return models;
        }


}