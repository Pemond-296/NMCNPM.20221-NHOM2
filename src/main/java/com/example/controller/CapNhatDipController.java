package com.example.controller;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.service.IEventGiftService;
import com.example.service.IMinhChungService;
import com.example.service.impl.EventGiftService;
import com.example.service.impl.MinhChungService;
import com.example.utils.DateUtil;
import com.example.utils.DipUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CapNhatDipController implements Initializable {
    private IEventGiftService eventGiftService = new EventGiftService();
    private EventGiftModel eventGiftModel ;
    @FXML
    private AnchorPane CapNhatDip;

    @FXML
    private DatePicker Date;

    @FXML
    private TextField FDoiTuongNhan;

    @FXML
    private TextField FPhanQua;

    @FXML
    private TextField FTenDip;


    @FXML
    void ESave(ActionEvent event) {
        EventGiftModel model = new EventGiftModel();
        if (DipUtil.getInstance().getData() != null) model.setId(DipUtil.getInstance().getData().getId());
        model.setTen_doi_tuong(this.FDoiTuongNhan.getText());
        model.setDate(DateUtil.asDate(Date.getValue()));
        model.setNameEvent(FTenDip.getText());
        model.setIdQua(1L);
        eventGiftService.update(model);

        DipUtil.getInstance().removeData();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void EXoaDip(ActionEvent event) {
        eventGiftService.delete(DipUtil.getInstance().getData());

    }
    EventGiftModel model = DipUtil.getInstance().getData();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FDoiTuongNhan.setText(model.getTen_doi_tuong());
        FTenDip.setText(model.getNameEvent());
        FPhanQua.setText(model.getTen_qua());
    }
}
