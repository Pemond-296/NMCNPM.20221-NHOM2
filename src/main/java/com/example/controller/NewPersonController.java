package com.example.controller;

import com.example.model.IdentifierModel;
import com.example.model.LocationModel;
import com.example.model.PersonModel;
import com.example.service.IIdentifierService;
import com.example.service.ILocationService;
import com.example.service.IPersonService;
import com.example.service.impl.IdentifierService;
import com.example.service.impl.LocationService;
import com.example.service.impl.PersonService;
import com.example.utils.DateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.text.ParseException;

public class NewPersonController {
    private IPersonService personService = new PersonService();
    private IIdentifierService identifierService = new IdentifierService();
    private ILocationService locationService = new LocationService();
    @FXML
    private AnchorPane AddPerson;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegister;

    @FXML
    private DatePicker date;

    @FXML
    private TextField ethnic;

    @FXML
    private RadioButton female;

    @FXML
    private TextField fullname;

    @FXML
    private TextField hometown;

    @FXML
    private TextField idNumber;

    @FXML
    private TextField job;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton other;
    @FXML
    private TextField workPlace;
    @FXML
    private TextField registerPlace;
    @FXML
    public DatePicker registerDate;

    @FXML
    private TextField nickname;
    @FXML
    private ToggleGroup genderGroup;

    public void setBtnClear(ActionEvent event) {
        fullname.clear();
        date.getEditor().clear();
        job.clear();
        ethnic.clear();
        hometown.clear();
        idNumber.clear();
        workPlace.clear();
        registerPlace.clear();
        registerDate.getEditor().clear();
        nickname.clear();
    }
    public void setBtnRegister(ActionEvent event) throws ParseException {
        PersonModel model = new PersonModel();
        LocationModel locationModel = new LocationModel();
        IdentifierModel identifierModel = new IdentifierModel();

        identifierModel.setIdentityNumber(idNumber.getText());

        model.setLocationModel(locationModel);
        model.setIdentifierModel(identifierModel);
        model.setName(fullname.getText());
        model.setEthnic(ethnic.getText());
        model.setBirthDate(DateUtil.asDate(date.getValue()));
        model.setHometown(hometown.getText());
        model.setNickname(nickname.getText());
        model.setRegisterPlace(registerPlace.getText());
        model.setRegisterDate(DateUtil.asDate(registerDate.getValue()));


        if(male.isSelected()) model.setGender(male.getText());
        else if(female.isSelected()) model.setGender(female.getText());
        else model.setGender(other.getText());

        model.setJob(job.getText());
        model.setWorkPlace(workPlace.getText());

        Long id = personService.save(model);
        locationModel.setPersonId(id);
        identifierModel.setPersonId(id);
        locationService.save(locationModel);
        identifierService.save(identifierModel);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

}
