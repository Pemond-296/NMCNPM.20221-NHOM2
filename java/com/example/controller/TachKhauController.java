package com.example.controller;

import com.example.model.HoKhauModel;
import com.example.model.NhanKhauModel;
import com.example.service.IHoKhauService;
import com.example.service.INhanKhauService;
import com.example.service.impl.HoKhauService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.ApartmentUtil;
import com.example.utils.PersonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TachKhauController implements Initializable {
    private IHoKhauService hoKhauService = new HoKhauService();
    private INhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TextField chuHoCu;
    @FXML
    private TextField chuHoMoi;
    @FXML
    private TableColumn<?, ?> hoTenCu;
    @FXML
    private TableColumn<?, ?> hoTenMoi;
    @FXML
    private TextField khuVucCu;
    @FXML
    private TextField khuVucMoi;
    @FXML
    private TextField maHoKhauCu;
    @FXML
    private TextField maHoKhauMoi;
    @FXML
    private TableView<NhanKhauModel> newMemberTable;
    @FXML
    private TableColumn<?, ?> ngaySinhCu;
    @FXML
    private TableColumn<?, ?> ngaySinhMoi;
    @FXML
    private TableView<NhanKhauModel> oldMemberTable;
    @FXML
    private TextField phuongCu;
    @FXML
    private TextField phuongMoi;
    @FXML
    private TableColumn<?, ?> quanHeCu;
    @FXML
    private TableColumn<?, ?> quanHeMoi;
    @FXML
    private TextField soNhaCu;
    @FXML
    private TextField soNhaMoi;
    @FXML
    private TextField tenDuongCu;
    @FXML
    private TextField tenDuongMoi;

    private List<NhanKhauModel> thanhVienCu = nhanKhauService.findAllByApartmentId(ApartmentUtil.getInstance().getApartmentModel().getId());
    private ObservableList<NhanKhauModel> danhSachThanhVienCu = FXCollections.observableArrayList(thanhVienCu);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HoKhauModel hoKhauCu = ApartmentUtil.getInstance().getApartmentModel();

        maHoKhauCu.setText(hoKhauCu.getId());
        khuVucCu.setText(hoKhauCu.getQuanHuyen());
        soNhaCu.setText(hoKhauCu.getSoNha().toString());
        tenDuongCu.setText(hoKhauCu.getTenDuong());
        phuongCu.setText(hoKhauCu.getPhuongXa());
        chuHoCu.setText(hoKhauCu.getTenChuHo());

        hoTenCu.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinhCu.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        quanHeCu.setCellValueFactory(new PropertyValueFactory<>("quanHe"));

        hoTenMoi.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinhMoi.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        quanHeMoi.setCellValueFactory(new PropertyValueFactory<>("quanHe"));

        oldMemberTable.setItems(danhSachThanhVienCu);
    }

    public void newToOld(ActionEvent event) {
        NhanKhauModel model = newMemberTable.getSelectionModel().getSelectedItem();

        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn nhân khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

//        else if(model.getQuanHe() != null && model.getQuanHe().equals("Chủ hộ")) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Không thể chọn chủ hộ");
//            alert.setHeaderText("Không hợp lệ");
//            alert.showAndWait();
//        }

        else {
            if(model.getQuanHe() != null && model.getQuanHe().equals("Chủ hộ")) chuHoMoi.setText(null);
            newMemberTable.getItems().remove(model);
            model.setQuanHe(null);
            oldMemberTable.getItems().add(model);
        }

    }

    public void oldToNew(ActionEvent event) {
        NhanKhauModel model = oldMemberTable.getSelectionModel().getSelectedItem();


        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn nhân khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

//        else if(model.getQuanHe() != null && model.getQuanHe().equals("Chủ hộ")) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Không thể chọn chủ hộ");
//            alert.setHeaderText("Không hợp lệ");
//            alert.showAndWait();
//        }

        else {
            if(model.getQuanHe() != null && model.getQuanHe().equals("Chủ hộ")) chuHoCu.setText(null);
            oldMemberTable.getItems().remove(model);
            model.setQuanHe(null);
            newMemberTable.getItems().add(model);
        }
    }

    public void chonThanhVienCu(ActionEvent event) {
        PersonUtil.getInstance().setMember(oldMemberTable.getSelectionModel().getSelectedItem());
        NhanKhauModel model = PersonUtil.getInstance().getMember();

        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn nhân khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

        else {
            String relationship = JOptionPane.showInputDialog("Quan hệ với chủ hộ");
            if(relationship == null || relationship.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Thêm mới thất bại");
                alert.showAndWait();
            }

            else {
                model.setQuanHe(relationship);
                if(relationship.equals("Chủ hộ")) {
                    chuHoCu.setText(model.getHoTen());

                    for(NhanKhauModel ThanhVien : oldMemberTable.getItems()) {
                        if(ThanhVien.getQuanHe() != null) {
                            if(ThanhVien.getQuanHe().equals("Chủ hộ") && ThanhVien.getId() != model.getId()) {
                                ThanhVien.setQuanHe(null);
                                break;
                            }
                        }
                    }
                }

                boolean check = false;

                for(NhanKhauModel ThanhVien : oldMemberTable.getItems()) {
                    if(ThanhVien.getQuanHe() != null && ThanhVien.getQuanHe().equals("Chủ hộ")) check = true;
                }

                if(!check) chuHoCu.setText(null);

                oldMemberTable.refresh();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Thêm mới thành công");
                alert.showAndWait();
            }
        }
    }

    public void chonThanhVienMoi(ActionEvent event) {
        PersonUtil.getInstance().setMember(newMemberTable.getSelectionModel().getSelectedItem());
        NhanKhauModel model = PersonUtil.getInstance().getMember();

        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn nhân khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

        else {
            String relationship = JOptionPane.showInputDialog("Quan hệ với chủ hộ");
            if(relationship == null || relationship.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Thêm mới thất bại");
                alert.showAndWait();
            }

            else {
                model.setQuanHe(relationship);
                if(relationship.equals("Chủ hộ")) {
                    chuHoMoi.setText(model.getHoTen());

                    for(NhanKhauModel ThanhVien : newMemberTable.getItems()) {
                        if(ThanhVien.getQuanHe() != null) {
                            if(ThanhVien.getQuanHe().equals("Chủ hộ") && ThanhVien.getId() != model.getId()) {
                                ThanhVien.setQuanHe(null);
                                break;
                            }
                        }
                    }
                }

                boolean check = false;

                for(NhanKhauModel ThanhVien : newMemberTable.getItems()) {
                    if (ThanhVien.getQuanHe() != null && ThanhVien.getQuanHe().equals("Chủ hộ")) {
                        check = true;
                        break;
                    }
                }

                if(!check) chuHoMoi.setText(null);

                newMemberTable.refresh();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Thêm mới thành công");
                alert.showAndWait();
            }
        }
    }


    public void save(ActionEvent event) {
        if(maHoKhauMoi.getText() == "" || khuVucMoi.getText() == "" || soNhaMoi.getText() == "" ||
                tenDuongMoi.getText() == "" || phuongMoi.getText() == "" ||
                chuHoMoi.getText() == "" || chuHoCu.getText() == "" ||
                chuHoMoi.getText() == null || chuHoCu.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

        else {
            HoKhauModel hoKhauMoi = new HoKhauModel();
            HoKhauModel hoKhauCu = ApartmentUtil.getInstance().getApartmentModel();
            hoKhauMoi.setId(maHoKhauMoi.getText());
            hoKhauMoi.setQuanHuyen(khuVucMoi.getText());
            hoKhauMoi.setSoNha(Integer.valueOf(soNhaMoi.getText()));
            hoKhauMoi.setTenDuong(tenDuongMoi.getText());
            hoKhauMoi.setPhuongXa(phuongMoi.getText());
            hoKhauMoi.setTenChuHo(chuHoMoi.getText());
            hoKhauCu.setTenChuHo(chuHoCu.getText());

            hoKhauService.save(hoKhauMoi);
            for(NhanKhauModel model : newMemberTable.getItems()) {
                model.setIdHoKhau(hoKhauMoi.getId());
                nhanKhauService.update(model);
            }

            for(NhanKhauModel model : oldMemberTable.getItems()) {
                nhanKhauService.update(model);
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Thêm mới thành công");
            alert.showAndWait();

            ApartmentUtil.getInstance().setNewApartmentModel(hoKhauMoi);

            exit(event);
        }

    }
    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
