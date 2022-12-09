package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.model.PersonModel;
import com.example.service.IApartmentService;
import com.example.service.IPersonService;
import com.example.service.impl.ApartmentService;
import com.example.service.impl.PersonService;
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

public class NewApartmentController implements Initializable {
    private IApartmentService apartmentService = new ApartmentService();
    private IPersonService personService = new PersonService();
    @FXML
    private TextField id;
    @FXML
    private TextField districtName;
    @FXML
    private TextField apartmentNumber;
    @FXML
    private TextField roadName;
    @FXML
    private TextField wardsName;
    @FXML
    private TextField monitorName;
    @FXML
    private TextField monitorDate;
    @FXML
    private TextField monitorIdNumber;
    @FXML
    private TableView<PersonModel> memberTable;
    @FXML
    private TableColumn<?, ?> memberName;
    @FXML
    private TableColumn<?, ?> memberDate;
    @FXML
    private TableColumn<?, ?> memberRelationship;
    ObservableList<PersonModel> observableMemberList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PersonUtil.getInstance().removeData();

        memberName.setCellValueFactory(new PropertyValueFactory<>("name"));
        memberDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        memberRelationship.setCellValueFactory(new PropertyValueFactory<>("relationship"));
    }

    public void selectMonitor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NewApartmentController.class.getResource("MonitorTable.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        PersonModel tempMonitor = PersonUtil.getInstance().getMonitor();

        if(tempMonitor != null) {
            tempMonitor.setRelationship("Chủ hộ");

            monitorName.setText(tempMonitor.getName());
            monitorDate.setText(tempMonitor.getBirthDate().toString());
            monitorIdNumber.setText(tempMonitor.getIdentifierModel().getIdentityNumber());

            PersonUtil.getInstance().setMember(null);
            observableMemberList.clear();
            observableMemberList.add(tempMonitor);
            memberTable.setItems(observableMemberList);

        }
    }

    public void selectMember(ActionEvent event) throws IOException {
        if (monitorName.getText() != "") {
            Parent root = FXMLLoader.load(Objects.requireNonNull(NewApartmentController.class.getResource("MemberTable.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();

            PersonModel member = PersonUtil.getInstance().getMember();
            if(member != null) {
                PersonUtil.getInstance().getTempModel().add(member);
                observableMemberList.add(member);
                memberTable.setItems(observableMemberList);
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
        ApartmentModel model = new ApartmentModel();
        PersonModel tempModel = PersonUtil.getInstance().getMonitor();

        model.setId(id.getText());
        model.setDistrictName(districtName.getText());
        model.setApartmentNumber(Integer.valueOf(apartmentNumber.getText()));
        model.setRoadName(roadName.getText());
        model.setWardsName(wardsName.getText());
        model.setName(tempModel.getName());

        ApartmentUtil.getInstance().add(model);

        apartmentService.save(model);

        List<PersonModel> list = new ArrayList<>(memberTable.getItems());
        for(PersonModel personModel : list) {
            personModel.setApartmentId(model.getId());
            personService.update(personModel);
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
