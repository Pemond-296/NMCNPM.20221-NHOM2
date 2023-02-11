package com.example.controller;

import com.example.model.EventGiftModel;
import com.example.service.IMinhChungService;
import com.example.service.impl.EventGiftService;
import com.example.service.impl.MinhChungService;
import com.example.utils.DipUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuanLiDipController implements Initializable {
    private EventGiftService eventGiftService = new EventGiftService();

    @FXML
    private TableView<EventGiftModel> DipTable;

    @FXML
    private Button CapNhatB;

    @FXML
    private TableColumn<?, ?> DoiTuongNhanC;
    @FXML
    private Button MinhChungB;
    @FXML
    private Button DanhSachB;

    @FXML
    private TableColumn<?, ?> PhanQuaC;

    @FXML
    private TableColumn<?, ?> SttC;
    @FXML
    private TextField TimKiemT;

    @FXML
    private Button TaoMoiDipB;

    @FXML
    private TableColumn<?, ?> TenDipC;

    @FXML
    private TableColumn<?, ?> ThoiGianC;
    @FXML
    private TableColumn<?, ?> TrangThaiC;

    @FXML
    private Button XemB;

    ObservableList<EventGiftModel> observableListEvenGift = FXCollections.observableArrayList(getmember());
    @FXML
    void ClickE(ActionEvent event) {
    }
    @FXML
    void CapNhatE(ActionEvent event) throws IOException {
        EventGiftModel eventGiftModel = DipTable.getSelectionModel().getSelectedItem();
        DipUtil.getInstance().setData(eventGiftModel);
        if (DipUtil.getInstance().getData() != null) {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(CapNhatDipController.class.getResource("CapNhatDip.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            observableListEvenGift.clear();
            observableListEvenGift.addAll(getmember());
            DipTable.setItems(observableListEvenGift);

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn chọn dịp");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }

    }
    List<EventGiftModel> getmember(){
        IMinhChungService minhChungService = new MinhChungService();
        List<EventGiftModel> list = DipUtil.getInstance().getEventGiftModelList();
        for(int i = 0; i < list.size(); i++){
            list.get(i).setStt(i+1);
            if(minhChungService.check(list.get(i)) == true){
                list.get(i).setTrang_thai_bool(1);
            }
            else {
                list.get(i).setTrang_thai_bool(0);
            }

        }
        return list;
    }

    @FXML
    private MenuButton menuLoc;

    @FXML
    void LapDanhSachE(ActionEvent event) throws IOException {

        DipUtil.getInstance().setData(DipTable.getSelectionModel().getSelectedItem());
        if (DipUtil.getInstance().getData() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn chọn dịp");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }
        else{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("LapDanhSach.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            observableListEvenGift.clear();
            observableListEvenGift.addAll(getmember());
            DipTable.setItems(observableListEvenGift);
        }
    }
    @FXML
    void TimKiemE(KeyEvent event) {
        String keyword = TimKiemT.getText();
        List<EventGiftModel> models = DipTable.getItems();
        if(keyword.isEmpty()) {
            observableListEvenGift.clear();
            observableListEvenGift.addAll(getmember());
            DipTable.refresh();
            return;
        }

        observableListEvenGift.clear();
        observableListEvenGift.addAll(DipUtil.getInstance().findByName(keyword.toLowerCase()));
        DipTable.refresh();

    }

    @FXML
    void TaoMoiE(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("TaoMoiDip.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        observableListEvenGift.clear();
        observableListEvenGift.addAll(getmember());
        DipTable.setItems(observableListEvenGift);
    }
    @FXML
    void MinhChungE(ActionEvent event) throws IOException {
        DipUtil.getInstance().setData(DipTable.getSelectionModel().getSelectedItem());
        if (DipUtil.getInstance().getData() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn dịp");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }
        else{
            if(DipUtil.getInstance().getData().getLoai_dip() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Dịp giữa năm, không cần tạo minh chứng");
                alert.setHeaderText("Lỗi");
                alert.showAndWait();
            }
            else{
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("QuanLiMinhChung.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.showAndWait();
            }
        }
    }
    @FXML
    void XemE(ActionEvent event) throws IOException {
        DipUtil.getInstance().setData(DipTable.getSelectionModel().getSelectedItem());
        if (DipUtil.getInstance().getData() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng chọn dịp");
            alert.setHeaderText("Lỗi");
            alert.showAndWait();
        }
        else{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("ThongKeTT.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            observableListEvenGift.clear();
            observableListEvenGift.addAll(getmember());
            DipTable.setItems(observableListEvenGift);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SttC.setCellValueFactory(new PropertyValueFactory<>("stt"));
        TenDipC.setCellValueFactory(new PropertyValueFactory<>("nameEvent"));
        ThoiGianC.setCellValueFactory(new PropertyValueFactory<>("date"));
        DoiTuongNhanC.setCellValueFactory(new PropertyValueFactory<>("ten_doi_tuong"));
        PhanQuaC.setCellValueFactory(new PropertyValueFactory<>("ten_qua"));
        TrangThaiC.setCellValueFactory(new PropertyValueFactory<>("trang_thai"));
        DipTable.setItems(observableListEvenGift);
    }
    @FXML
    void ChuaHoanThanh(ActionEvent event) {
        menuLoc.setText("Chưa hoàn thành");
        String key = TimKiemT.getText();
        observableListEvenGift.clear();
        observableListEvenGift.addAll(DipUtil.getInstance().findByStatus(true, key.toLowerCase()));


        DipTable.setItems(observableListEvenGift);
    }

    @FXML
    void HoanThanh(ActionEvent event) {
        menuLoc.setText("Hoàn thành");
        String key = TimKiemT.getText();
        observableListEvenGift.clear();
        observableListEvenGift.addAll(DipUtil.getInstance().findByStatus(false, key.toLowerCase()));
//        List<EventGiftModel> models_curr = DipTable.getItems();
//
//        for (EventGiftModel model : models_curr){
//
//            if (model.getTrang_thai_bool() == 1){
//                observableListEvenGift.add(model);
//            }
//
//        }
        DipTable.setItems(observableListEvenGift);

    }
}
