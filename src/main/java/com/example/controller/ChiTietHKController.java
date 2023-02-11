package com.example.controller;

import com.example.model.HoKhauModel;
import com.example.model.NhanKhauModel;
import com.example.service.IHoKhauService;
import com.example.service.INhanKhauService;
import com.example.service.impl.HoKhauService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.ApartmentUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChiTietHKController implements Initializable {
    private IHoKhauService hoKhauService = new HoKhauService();
    private INhanKhauService nhanKhauService = new NhanKhauService();

    @FXML
    private TextField id;
    @FXML
    private TableColumn<?, ?> ngaySinhThanhVien;
    @FXML
    private TextField phuongXa;
    @FXML
    private TableColumn<?, ?> quanHe;
    @FXML
    private TextField quanHuyen;
    @FXML
    private TextField soNha;
    @FXML
    private TextField tenChuHo;
    @FXML
    private TextField tenDuong;
    @FXML
    private TableColumn<?, ?> tenThanhVien;
    @FXML
    private TableView<NhanKhauModel> thanhVienTable;
    private HoKhauModel hoKhauModel = ApartmentUtil.getInstance().getApartmentModel();
    private List<NhanKhauModel> nhanKhauModelList = nhanKhauService.findAllByApartmentId(hoKhauModel.getId());
    ObservableList<NhanKhauModel> observableList = FXCollections.observableArrayList(nhanKhauModelList);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setText(hoKhauModel.getId());
        quanHuyen.setText(hoKhauModel.getQuanHuyen());
        soNha.setText(hoKhauModel.getSoNha().toString());
        tenDuong.setText(hoKhauModel.getTenDuong());
        phuongXa.setText(hoKhauModel.getPhuongXa());
        tenChuHo.setText(hoKhauModel.getTenChuHo());

        tenThanhVien.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinhThanhVien.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        quanHe.setCellValueFactory(new PropertyValueFactory<>("quanHe"));
        thanhVienTable.setItems(observableList);
    }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void save(ActionEvent event) {
        if (id.getText().isBlank() || quanHuyen.getText().isBlank() || soNha.getText().isBlank() ||
                tenDuong.getText().isBlank() || phuongXa.getText().isBlank() || tenChuHo.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

        else {
            hoKhauModel.setTenChuHo(tenChuHo.getText());
            hoKhauModel.setQuanHuyen(quanHuyen.getText());
            hoKhauModel.setSoNha(Integer.valueOf(soNha.getText()));
            hoKhauModel.setTenDuong(tenDuong.getText());
            hoKhauModel.setPhuongXa(phuongXa.getText());

            hoKhauService.update(hoKhauModel);

            for(NhanKhauModel model : thanhVienTable.getItems()) {
                nhanKhauService.update(model);
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Thay đổi thành công");
            alert.showAndWait();
            exit(event);
        }
    }

    @FXML
    void ThayDoiQH(ActionEvent event) {
        NhanKhauModel model = thanhVienTable.getSelectionModel().getSelectedItem();

        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn nhân khẩu");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

        else {
            String[] option = {"Chủ hộ", "Thành viên"};
            Object searchType = JOptionPane.showInputDialog(null, null, "Chọn quan hệ",
                        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

            if(searchType == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Thay đổi thất bại");
                alert.setHeaderText("Lỗi");
                alert.showAndWait();
            }

            else {
                if(searchType.equals(option[0])) {
                    model.setQuanHe("Chủ hộ");
                    tenChuHo.setText(model.getHoTen());

                    for(NhanKhauModel ThanhVien : thanhVienTable.getItems()) {
                        if(ThanhVien.getQuanHe() != null) {
                            if(ThanhVien.getQuanHe().equals("Chủ hộ") && ThanhVien.getId() != model.getId()) {
                                ThanhVien.setQuanHe(null);
                                break;
                            }
                        }
                    }

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Thêm mới thành công");
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
                        boolean check = false;

                        for(NhanKhauModel ThanhVien : thanhVienTable.getItems()) {
                            if (ThanhVien.getQuanHe() != null && ThanhVien.getQuanHe().equals("Chủ hộ")) {
                                check = true;
                                break;
                            }
                        }

                        if(!check) tenChuHo.setText(null);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Thêm mới thành công");
                        alert.showAndWait();
                    }
                }

                thanhVienTable.refresh();


            }


        }
    }

}
