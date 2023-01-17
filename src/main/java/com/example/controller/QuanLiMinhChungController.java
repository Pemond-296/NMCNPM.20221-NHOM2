package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.model.PersonModel;
import com.example.service.IMinhChungService;
import com.example.service.IPersonService;
import com.example.service.impl.MinhChungService;
import com.example.service.impl.PersonService;
import com.example.utils.PersonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuanLiMinhChungController implements Initializable {
    IPersonService iPersonService = new PersonService();
    IMinhChungService iMinhChungService = new MinhChungService();
    @FXML
    private TableColumn<ApartmentModel, ?> ho_gia_dinh;

    @FXML
    private TableColumn<?, ?> ho_ten;

    @FXML
    private TableColumn<?, ?> minh_chung;

    @FXML
    private TableColumn<?, ?> ngay_sinh;

    @FXML
    private TableView<PersonModel> nhan_khauTable;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TextField tim_kiemText;


    @FXML
    void tim_kiem(ActionEvent event) {

    }

    List<PersonModel> personModelList = iPersonService.findByAge();
    ObservableList<PersonModel> observableList = FXCollections.observableArrayList(getMinhChung());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stt.setCellValueFactory(new PropertyValueFactory<>("id"));
        ho_ten.setCellValueFactory(new PropertyValueFactory<>("name"));
        ngay_sinh.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        ho_gia_dinh.setCellValueFactory(new PropertyValueFactory<>("gender"));
        minh_chung.setCellValueFactory(new PropertyValueFactory<>("proof"));
        nhan_khauTable.setItems(observableList);
    }

    List<PersonModel> getMinhChung(){

        for (PersonModel personModel : personModelList){

            if(iMinhChungService.isMinhChung(personModel) == 1){
                personModel.setProof("Đã có");
            }
            else personModel.setProof("Chưa có");

        }
        return personModelList;

    }
    @FXML
    void tao_minh_chung(ActionEvent event) throws IOException {
        PersonUtil.getInstance().setMinhChung(nhan_khauTable.getSelectionModel().getSelectedItem());
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("TaoMinhChung.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        observableList.clear();
        observableList.addAll(getMinhChung());
        nhan_khauTable.setItems(observableList);
    }

}
