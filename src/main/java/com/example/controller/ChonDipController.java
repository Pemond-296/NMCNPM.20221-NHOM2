package com.example.controller;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;
import com.example.service.IEventGiftService;
import com.example.service.IMinhChungService;
import com.example.service.INhanKhauService;
import com.example.service.impl.EventGiftService;
import com.example.service.impl.MinhChungService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.DipUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChonDipController implements Initializable {
    IEventGiftService eventGiftService = new EventGiftService();
    INhanKhauService nhanKhauService = new NhanKhauService();
    IMinhChungService minhChungService = new MinhChungService();
    @FXML
    private TableView<EventGiftModel> dipTable;

    @FXML
    private TableColumn<?, ?> doi_tuong_nhan;

    @FXML
    private TableColumn<?, ?> ten_dip;

    @FXML
    private TableColumn<?, ?> thoi_gian;

    @FXML
    void chon(ActionEvent event) throws IOException {
        EventGiftModel eventGiftModel = dipTable.getSelectionModel().getSelectedItem();
        DipUtil.getInstance().setData(eventGiftModel);
        if(eventGiftModel.getLoai_dip() == 0){ //giua nam
            List<NhanKhauModel> nhanKhauModels = nhanKhauService.findByAge();
            if(!nhanKhauModels.isEmpty()){
                for(NhanKhauModel personModel : nhanKhauModels){
                    if (minhChungService.isMinhChung(personModel) == 1){
                        continue;
                    }
                    MinhChungModel minhChungModel = new MinhChungModel();
                    minhChungModel.setId_nhan_khau(personModel.getId());
                    minhChungModel.setId_thanhtich(1L); // tre em
                    minhChungModel.setId_dip(eventGiftModel.getId());
                    Long save = minhChungService.save(minhChungModel);
                }
            }
        }

        Stage stagex = new Stage();
        Parent rootx = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("LapDanhSach.fxml")));
        Scene scenex = new Scene(rootx);
        stagex.setScene(scenex);
        stagex.showAndWait();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    List<EventGiftModel> models = DipUtil.getInstance().getEventGiftModelList();
    ObservableList<EventGiftModel> observableList = FXCollections.observableArrayList(models);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ten_dip.setCellValueFactory(new PropertyValueFactory<>("nameEvent"));
        doi_tuong_nhan.setCellValueFactory(new PropertyValueFactory<>("ten_doi_tuong"));
        thoi_gian.setCellValueFactory((new PropertyValueFactory<>("date")));
        dipTable.setItems(observableList);
    }

}
