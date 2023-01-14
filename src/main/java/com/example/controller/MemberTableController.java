package com.example.controller;

import com.example.model.PersonModel;
import com.example.service.IPersonService;
import com.example.service.impl.PersonService;
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

public class MemberTableController implements Initializable {
    private IPersonService personService = new PersonService();
    @FXML
    private TableColumn<?, ?> birthDate;

    @FXML
    private TableColumn<?, ?> ethnic;

    @FXML
    private TableColumn<?, ?> homeTown;

    @FXML
    private TableColumn<?, ?> identifyNumber;

    @FXML
    private TableColumn<?, ?> job;

    @FXML
    private TableColumn<?, ?> personId;

    @FXML
    private TableColumn<?, ?> personName;

    @FXML
    private TableView<PersonModel> personTable;
    ObservableList<PersonModel> observablePersonList = FXCollections.observableArrayList(getMember());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personId.setCellValueFactory(new PropertyValueFactory<>("id"));
        personName.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        ethnic.setCellValueFactory(new PropertyValueFactory<>("ethnic"));
        homeTown.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        identifyNumber.setCellValueFactory(new PropertyValueFactory<>("identifyId"));
        personTable.setItems(observablePersonList);
    }
    @FXML
    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save(ActionEvent event) {
        PersonModel model = personTable.getSelectionModel().getSelectedItem();
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
                model.setRelationship(relationship);
                PersonUtil.getInstance().setMember(model);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Thêm mới thành công");
                alert.showAndWait();

                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.close();
            }

        }
    }

    private List<PersonModel> getMember() {
        List<PersonModel> models = personService.findMonitor();
        PersonModel monitor = PersonUtil.getInstance().getMonitor();
        List<PersonModel> members = PersonUtil.getInstance().getTempModel();

        for(PersonModel model : models) {
            if(model.getId().equals(monitor.getId())) {
                models.remove(model);
                break;
            }
        }

        if(members != null) {
            for(PersonModel member : members) {
                for(PersonModel model : models) {
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
