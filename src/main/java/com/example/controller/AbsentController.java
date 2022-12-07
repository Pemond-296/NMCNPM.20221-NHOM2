package com.example.controller;

import com.example.model.AbsentModel;
import com.example.model.PersonModel;
import com.example.service.IAbsentService;
import com.example.service.impl.AbsentService;
import com.example.utils.DateUtil;
import com.example.utils.PersonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Objects;

public class AbsentController {
    private IAbsentService absentService = new AbsentService();
    @FXML
    private TextField address;

    @FXML
    private ImageView checkImg;

    @FXML
    private DatePicker dateBack;

    @FXML
    private DatePicker dateMove;

    @FXML
    private TextField identityNumber;

    @FXML
    private TextField name;

    @FXML
    private TextArea note;
    private Long personId;

    public void check(ActionEvent event) {
        List<PersonModel> modelList = PersonUtil.getInstance().getModels();

        if(identityNumber.getText().isEmpty()) {
            checkImg.setImage(new Image(Objects.requireNonNull(AbsentController.class.getResourceAsStream("images/unchecked.png"))));
            name.clear();
            address.clear();
            return;
        }

        for(PersonModel model : modelList) {
            if(model.getIdentifierModel().getIdentityNumber().trim().equals(identityNumber.getText())) {
                checkImg.setImage(new Image(Objects.requireNonNull(AbsentController.class.getResourceAsStream("images/accept.png"))));
                name.setText(model.getName());
                address.setText(model.getHometown());
                personId = model.getId();
                return;
            }
        }

        checkImg.setImage(new Image(Objects.requireNonNull(AbsentController.class.getResourceAsStream("images/failed.png"))));
        name.clear();
        address.clear();
    }

    public void submit(ActionEvent event) {
        if(address.getText().isEmpty() || dateMove.getEditor().getText().isEmpty() ||
                dateBack.getEditor().getText().isEmpty() || note.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
        }
        else {
            if(dateBack.getValue().compareTo(dateMove.getValue()) <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ngày không hợp lệ");
                alert.setContentText("Vui lòng chọn lại");
                alert.showAndWait();
            }

            else {
                AbsentModel model = new AbsentModel();
                model.setPersonId(personId);
                model.setDateMove(DateUtil.asDate(dateMove.getValue()));
                model.setDateBack(DateUtil.asDate(dateBack.getValue()));
                model.setNote(note.getText());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Khai báo thành công");
                alert.showAndWait();

                absentService.save(model);
            }
        }
    }
}
