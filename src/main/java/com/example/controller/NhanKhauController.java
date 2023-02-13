package com.example.controller;

import com.example.model.NhanKhauModel;
import com.example.service.impl.NhanKhauService;
import com.example.utils.PersonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NhanKhauController implements Initializable {
    private NhanKhauService nhanKhauService = new NhanKhauService();
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
    @FXML
    private TextField searchBar;
    ObservableList<NhanKhauModel> observablePersonList = FXCollections.observableArrayList(nhanKhauService.findAll());


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
//        startLoop();
    }

    public void addPerson(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("ThemNhanKhauView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        observablePersonList.clear();
        observablePersonList.addAll(nhanKhauService.findAll());
        nhanKhauTable.setItems(observablePersonList);
    }

    public void tamTru(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("TamTruView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        if(PersonUtil.getInstance().getTamTru() != null) {
            nhanKhauTable.getItems().add(PersonUtil.getInstance().getTamTru());
            nhanKhauTable.refresh();
        }
    }

    public void tamVang(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("TamVangView.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }


    public void khaiTu(ActionEvent event) throws IOException {
        NhanKhauModel model = nhanKhauTable.getSelectionModel().getSelectedItem();

        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Chưa chọn nhân khẩu");
            alert.setContentText("Vui lòng chọn lại");
            alert.showAndWait();
        }


        else {
            if(model.getTamTruModel().getTuNgay() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Nhân khẩu tạm trú không thể khai tử");
                alert.showAndWait();
            }

            else if (model.getDiaDiemModel().getNoiChuyen() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Nhân khẩu đã chuyển đi nơi khác");
                alert.showAndWait();
            }

            else if(model.getKhaiTuModel().getNguoiKhaiTu() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Đã khai tử");
                alert.showAndWait();
            }

            else {
                PersonUtil.getInstance().setKhaiTu(model);
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("KhaiTuView.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.showAndWait();
            }
        }
    }

    public void timKiem(KeyEvent keyEvent) {
        String keyword = searchBar.getText();
        List<NhanKhauModel> models = nhanKhauService.findAll();
        if(keyword.isEmpty()) {
            observablePersonList.clear();
            observablePersonList.addAll(models);
            nhanKhauTable.refresh();
            return;
        }

        observablePersonList.clear();

        for(NhanKhauModel model : models) {
            if(model.getHoTen().toLowerCase().contains(keyword.toLowerCase())) {
                observablePersonList.add(model);
            }
        }

        nhanKhauTable.refresh();
    }

    public void chuyenDi(ActionEvent event) throws IOException {
        NhanKhauModel model = nhanKhauTable.getSelectionModel().getSelectedItem();
        if(model == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Chưa chọn nhân khẩu");
            alert.setContentText("Vui lòng chọn lại");
            alert.showAndWait();
        }

        else {
            if(model.getDiaDiemModel().getNoiChuyen() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Nhân khẩu đã chuyển đi");
                alert.showAndWait();
            }

            else if(model.getTamTruModel().getTuNgay() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Nhân khẩu tạm trú không thể chuyển đi");
                alert.showAndWait();
            }

            else if(model.getKhaiTuModel().getNguoiKhaiTu() != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi");
                alert.setContentText("Đã qua đời");
                alert.showAndWait();
            }

            else {
                PersonUtil.getInstance().setChuyenDi(model);
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(ThemNhanKhauController.class.getResource("ChuyenDi.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.showAndWait();
            }
        }

    }


//    public void startLoop() {
//        Thread myThread = new Thread(this);
//        myThread.start();
//    }
//
//    @Override
//    public void run() {
//        String oldText = "";
//        List<NhanKhauModel> models = nhanKhauService.findAll();
//        System.out.println("Run");
//
//        while(true) {
//            String newText = searchBar.getText();
//            System.out.println(newText);
//            System.out.println(oldText);
//            if(!Objects.equals(newText, oldText)) {
//                oldText = newText;
//
//                if(newText.isEmpty()) {
//                    observablePersonList.clear();
//                    observablePersonList.addAll(models);
//                    nhanKhauTable.refresh();
//                }
//
//                else {
//                    String[] substring = newText.split(" ");
//                    observablePersonList.clear();
//
//                    for(NhanKhauModel model : models) {
//                        for(String s : substring) {
//                            String name = model.getHoTen().toLowerCase();
//                            if(name.contains(s.toLowerCase())) {
//                                observablePersonList.add(model);
//                                break;
//                            }
//                        }
//                    }
//
//                    nhanKhauTable.refresh();
//                }
//            }
//        }
//
//    }
}
