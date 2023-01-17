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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ThemHoKhauController implements Initializable {
    private IHoKhauService apartmentService = new HoKhauService();
    private INhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TextField id;
    @FXML
    private TextField quanHuyen;
    @FXML
    private TextField soNha;
    @FXML
    private TextField tenDuong;
    @FXML
    private TextField phuongXa;
    @FXML
    private TextField tenChuHo;
    @FXML
    private TextField ngaySinhChuHo;
    @FXML
    private TextField idChuHo;
    @FXML
    private TableView<NhanKhauModel> thanhVienTable;
    @FXML
    private TableColumn<?, ?> tenThanhVien;
    @FXML
    private TableColumn<?, ?> ngaySinhThanhVien;
    @FXML
    private TableColumn<?, ?> quanHe;
    ObservableList<NhanKhauModel> observableMemberList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PersonUtil.getInstance().removeData();

        tenThanhVien.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaySinhThanhVien.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        quanHe.setCellValueFactory(new PropertyValueFactory<>("quanHe"));
    }

    public void selectMonitor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ChuHoTable.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        NhanKhauModel tempMonitor = PersonUtil.getInstance().getMonitor();

        if(tempMonitor != null && !Objects.equals(tenChuHo.getText(), tempMonitor.getHoTen())) {
            tempMonitor.setQuanHe("Chủ hộ");

            tenChuHo.setText(tempMonitor.getHoTen());
            ngaySinhChuHo.setText(tempMonitor.getNgaySinh().toString());
            idChuHo.setText(tempMonitor.getIdentifierModel().getSoCMT());

            PersonUtil.getInstance().setMember(null);
            PersonUtil.getInstance().setTempModel(new ArrayList<>());
            observableMemberList.clear();
            observableMemberList.add(tempMonitor);
            thanhVienTable.setItems(observableMemberList);

        }
    }

    public void selectMember(ActionEvent event) throws IOException {
        if (tenChuHo.getText() != "") {
            Parent root = FXMLLoader.load(Objects.requireNonNull(ThemHoKhauController.class.getResource("ThanhVienTable.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();

            NhanKhauModel member = PersonUtil.getInstance().getMember();
            if(member != null) {
                PersonUtil.getInstance().getTempModel().add(member);
                observableMemberList.add(member);
                thanhVienTable.setItems(observableMemberList);
                PersonUtil.getInstance().setMember(null);
            }
        }

        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn chủ hộ");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }
    }

    public void save(ActionEvent event) {
        HoKhauModel model = new HoKhauModel();
        NhanKhauModel tempModel = PersonUtil.getInstance().getMonitor();

        model.setId(id.getText());
        model.setQuanHuyen(quanHuyen.getText());
        model.setSoNha(Integer.valueOf(soNha.getText()));
        model.setTenDuong(tenDuong.getText());
        model.setPhuongXa(phuongXa.getText());
        model.setTenChuHo(tempModel.getHoTen());

        ApartmentUtil.getInstance().add(model);

        apartmentService.save(model);

        List<NhanKhauModel> list = new ArrayList<>(thanhVienTable.getItems());
        for(NhanKhauModel nhanKhauModel : list) {
            nhanKhauModel.setIdHoKhau(model.getId());
            nhanKhauService.update(nhanKhauModel);
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
