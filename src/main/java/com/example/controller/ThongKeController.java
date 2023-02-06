package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.model.ThongKeModel;
import com.example.service.IThongKeService;
import com.example.service.impl.NhanKhauService;
import com.example.service.impl.ThongKeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {
    private IThongKeService thongKeService = new ThongKeService();
    @FXML
    private TableColumn<?, ?> diaChi;
    @FXML
    private ChoiceBox<String> genderBox;
    @FXML
    private TableColumn<?, ?> gioiTinh;
    @FXML
    private TableColumn<?, ?> hoTen;
    @FXML
    private TableColumn<?, ?> ngaySinh;
    @FXML
    private TableColumn<?, ?> nhanKhauId;
    @FXML
    private TableView<ThongKeModel> nhanKhauTable;
    private final String[] allGender = {"Toàn bộ", "Nam", "Nữ", "Khác"};
    private List<ThongKeModel> thongKeModelList = thongKeService.findAll();
    private ObservableList<ThongKeModel> observablePersonList = FXCollections.observableArrayList(thongKeModelList);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.setValue("Toàn bộ");
        genderBox.getItems().addAll(allGender);
        nhanKhauId.setCellValueFactory(new PropertyValueFactory<>("id"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        diaChi.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
        nhanKhauTable.setItems(observablePersonList);
    }

    public void kiemTra(ActionEvent event) {
        String gioiTinh = genderBox.getValue();
        observablePersonList.clear();

        if(gioiTinh.equals("Toàn bộ")) {
            observablePersonList = FXCollections.observableArrayList(thongKeModelList);
            nhanKhauTable.setItems(observablePersonList);
        }

        else {
            for(ThongKeModel model : thongKeModelList) {
                if(model.getGioiTinh().equals(gioiTinh)) observablePersonList.add(model);
//                System.out.println(Year.now().getValue() - model.getNgaySinh().toLocalDate().getYear());
            }
        }


        nhanKhauTable.refresh();
    }
}
