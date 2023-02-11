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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {
    public TextField fromAge;
    public TextField toAge;
    private IThongKeService thongKeService = new ThongKeService();
    @FXML
    private TableColumn<?, ?> diaChi;
    @FXML
    private ChoiceBox<String> genderBox;
    @FXML
    private ChoiceBox<String> statusBox;
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
    private final String[] allStatus = {"Toàn bộ", "Còn sống", "Đã mất", "Tạm trú", "Tạm vắng"};
    private List<ThongKeModel> thongKeModelList = thongKeService.findAll();
    private ObservableList<ThongKeModel> observablePersonList = FXCollections.observableArrayList(thongKeModelList);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.setValue("Toàn bộ");
        genderBox.getItems().addAll(allGender);
        statusBox.setValue("Toàn bộ");
        statusBox.getItems().addAll(allStatus);

        nhanKhauId.setCellValueFactory(new PropertyValueFactory<>("id"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        diaChi.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
        nhanKhauTable.setItems(observablePersonList);
    }

    public void kiemTra(ActionEvent event) {
        observablePersonList.clear();

        kiemTraGioiTinh();
        kiemTraTinhTrang();
        kiemTraTuoi();

        nhanKhauTable.refresh();
    }

    public void kiemTra2(KeyEvent keyEvent) {
        observablePersonList.clear();

        kiemTraGioiTinh();
        kiemTraTinhTrang();
        kiemTraTuoi();


        nhanKhauTable.refresh();
    }


    public void kiemTraGioiTinh() {
        String gioiTinh = genderBox.getValue();

        if(gioiTinh.equals("Toàn bộ")) {
            observablePersonList = FXCollections.observableArrayList(thongKeModelList);
            nhanKhauTable.setItems(observablePersonList);
        }

        else {
            for(ThongKeModel model : thongKeModelList) {
                if(model.getGioiTinh() != null) {
                    if(model.getGioiTinh().equals(gioiTinh)) observablePersonList.add(model);
                }

            }
        }
    }

    public void kiemTraTinhTrang() {
        String tinhTrang = statusBox.getValue();
        if(tinhTrang == null) tinhTrang = "Toàn bộ";
        if(tinhTrang.equals("Còn sống")) {
            observablePersonList.removeIf(model -> model.getKhaiTuModel().getNguoiKhaiTu() != null);
        }

        else if(tinhTrang.equals("Đã mất")) {
            observablePersonList.removeIf(model -> model.getKhaiTuModel().getNguoiKhaiTu() == null);
        }

        else if(tinhTrang.equals("Tạm trú")) {
            observablePersonList.removeIf(model -> model.getTamTruModel().getTuNgay() == null);
        }
        else if(tinhTrang.equals("Tạm vắng")) {
            observablePersonList.removeIf(model -> model.getTamVangModel().getNgayDi() == null);
        }
    }
    public void kiemTraTuoi() {
        String tuoiTu = fromAge.getText();
        String tuoiDen = toAge.getText();

        int begin = 0;
        int end = 999999;

        if(!tuoiTu.isBlank()) {
            begin = Integer.parseInt(tuoiTu);
        }

        if(!tuoiDen.isBlank()) {
            end = Integer.parseInt(tuoiDen);
        }

        int finalBegin = begin;
        int finalEnd = end;
        observablePersonList.removeIf(model -> ((tinhTuoi(model) < finalBegin || tinhTuoi(model) > finalEnd) && finalEnd >= finalBegin));
    }

    public int tinhTuoi(ThongKeModel model) {
        return Year.now().getValue() - model.getNgaySinh().toLocalDate().getYear();
    }


}
