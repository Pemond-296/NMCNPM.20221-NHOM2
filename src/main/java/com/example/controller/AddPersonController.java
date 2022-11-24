package com.example.controller;

import com.example.model.PersonModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddPersonController {

    @FXML
    private AnchorPane AddPerson;

    @FXML
    private TextField apartment;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField date;

    @FXML
    private TextField ethnic;

    @FXML
    private RadioButton female;

    @FXML
    private TextField fullname;

    @FXML
    private TextField hometown;

    @FXML
    private TextField idnumber;

    @FXML
    private TextField job;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton other;

    @FXML
    void gender_male(ActionEvent event) {
        if (male.isSelected()) {
            female.setSelected(false);
            other.setSelected(false);
        }
    }

    public void gender_female(ActionEvent event) {
        if(female.isSelected())

    {
        male.setSelected(false);
        other.setSelected(false);
    }
}
    public void gender_other(ActionEvent event){
        if(other.isSelected()){
            female.setSelected(false);
            male.setSelected(false);
        }
    }
    @FXML
    void setBtnClear(ActionEvent event) {
        apartment.clear();
        fullname.clear();
        date.clear();
        job.clear();
        ethnic.clear();
        hometown.clear();
        idnumber.clear();
    }

    @FXML
    void setBtnRegister(ActionEvent event) {
    }

}
