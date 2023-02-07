package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.service.INhanKhauService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.PersonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ThanhVienTableController implements Initializable {
    private INhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TableColumn<?, ?> ngaySinh;

    @FXML
    private TableColumn<?, ?> danToc;

    @FXML
    private TableColumn<?, ?> nguyenQuan;

    @FXML
    private TableColumn<?, ?> soCMT;

    @FXML
    private TableColumn<?, ?> congViec;

    @FXML
    private TableColumn<?, ?> nhanKhauId;

    @FXML
    private TableColumn<?, ?> hoTen;

    @FXML
    private TableView<NhanKhauModel> nhanKhauTable;
    ObservableList<NhanKhauModel> observablePersonList = FXCollections.observableArrayList(getMember());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanKhauId.setCellValueFactory(new PropertyValueFactory<>("id"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        congViec.setCellValueFactory(new PropertyValueFactory<>("congViec"));
        danToc.setCellValueFactory(new PropertyValueFactory<>("danToc"));
        nguyenQuan.setCellValueFactory(new PropertyValueFactory<>("nguyenQuan"));
        soCMT.setCellValueFactory(new PropertyValueFactory<>("soCMT"));
        nhanKhauTable.setItems(observablePersonList);
    }
    @FXML
    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save(ActionEvent event) {
        NhanKhauModel model = nhanKhauTable.getSelectionModel().getSelectedItem();
        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Bạn chưa chọn nhân khẩu");
            alert.setContentText("Vui lòng chọn lại");
            alert.showAndWait();
        }

        else {
            JOptionPane JOptionPane = null;
            String relationship = JOptionPane.showInputDialog("Quan hệ với chủ hộ");
            if(relationship == null || relationship.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Thêm mới thất bại");
                alert.showAndWait();
            }

            else {
                model.setQuanHe(relationship);
                PersonUtil.getInstance().setMember(model);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Thêm mới thành công");
                alert.showAndWait();

                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.close();
            }

        }
    }

    private List<NhanKhauModel> getMember() {
        List<NhanKhauModel> models = nhanKhauService.findMonitor();     // Find all person do not have apartment_id
        NhanKhauModel monitor = PersonUtil.getInstance().getMonitor();    // Get the chosen monitor in prev screen
        List<NhanKhauModel> members = PersonUtil.getInstance().getTempModel();


        /**
            Remove monitor from the list
         **/
        for(NhanKhauModel model : models) {
            if(model.getId().equals(monitor.getId())) {
                models.remove(model);
                break;
            }
        }

        if(members != null) {
            for(NhanKhauModel member : members) {
                for(NhanKhauModel model : models) {
                    if(member.getId().equals(model.getId())) {
                        models.remove(model);
                        break;
                    }
                }
            }
        }


        return models;
    }
}
