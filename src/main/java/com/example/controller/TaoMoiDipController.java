package com.example.controller;


import com.example.model.EventGiftModel;
import com.example.service.IEventGiftService;
import com.example.service.IMinhChungService;
import com.example.service.INhanKhauService;
import com.example.service.impl.EventGiftService;
import com.example.service.impl.MinhChungService;
import com.example.service.impl.NhanKhauService;
import com.example.utils.DateUtil;
import com.example.utils.DipUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Calendar;

public class TaoMoiDipController {
    private IEventGiftService eventGiftService = new EventGiftService();
    private INhanKhauService personService = new NhanKhauService();
    private IMinhChungService minhChungService = new MinhChungService();
    private Integer loai_dipx;
    @FXML
    private DatePicker Date;

    @FXML
    private TextField DoiTuongNhanF;

    @FXML
    private TextField TenQuaF;

    @FXML
    private Button taoMoiB;
    @FXML
    private MenuItem cuoi_nam;

    @FXML
    private MenuItem giua_nam;
    @FXML
    private TextField tenDipT;
    @FXML
    private MenuButton loai_dip;
    @FXML
    void cuoi_namEvent(ActionEvent event) {
        loai_dip.setText("Cuối năm");
        loai_dipx = 1;
    }

    @FXML
    void giua_namEvent(ActionEvent event) {
        loai_dip.setText("Giữa năm");
        loai_dipx = 0;
    }

    @FXML
    public void TaoMoiE(ActionEvent event) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        EventGiftModel eventGiftModel = new EventGiftModel();
        eventGiftModel.setNameEvent(tenDipT.getText());
        eventGiftModel.setDate(DateUtil.asDate(Date.getValue()));
        eventGiftModel.setTen_doi_tuong(DoiTuongNhanF.getText());

        if(loai_dipx == 0 ){
            eventGiftModel.setLoai_dip(0);
            eventGiftModel.setIdQua(1L);
        }
        else {
            eventGiftModel.setLoai_dip(1);
            eventGiftModel.setIdQua(2L);
        }

        Long id = eventGiftService.save(eventGiftModel);
        DipUtil.getInstance().addDip(eventGiftModel);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

}
