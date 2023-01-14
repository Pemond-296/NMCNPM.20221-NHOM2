package com.example.controller;

import com.example.model.MinhChungModel;
import com.example.service.IMinhChungService;
import com.example.service.impl.MinhChungService;
import com.example.utils.DipUtil;
import com.example.utils.PersonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TaoMinhChungController implements Initializable {
    private Integer thanh_tichx;
    private IMinhChungService iMinhChungService = new MinhChungService();
    @FXML
    private MenuItem gioi;

    @FXML
    private TextField ho_tenText;


    @FXML
    private MenuItem kha;

    @FXML
    private MenuButton thanh_tich;

    @FXML
    private MenuItem yeu;

    @FXML
    void gioi(ActionEvent event) {
        thanh_tich.setText("Giỏi");
        thanh_tichx = 2;
    }

    @FXML
    void kha(ActionEvent event) {
        thanh_tich.setText("Khá");
        thanh_tichx = 3;
    }

    @FXML
    void luu(ActionEvent event) {
        MinhChungModel minhChungModel = new MinhChungModel();
        if(thanh_tichx == 2){
            minhChungModel.setId_thanhtich(2L);
        }
        else if(thanh_tichx == 3){
            minhChungModel.setId_thanhtich(3L);
        }
        else {
            minhChungModel.setId_thanhtich(4L);
        }
        minhChungModel.setId_dip(DipUtil.getInstance().getData().getId());
        minhChungModel.setId_nhan_khau(PersonUtil.getInstance().getMinhchung().getId());
        minhChungModel.setNam(DipUtil.getInstance().getData().getDate().getYear());

        if(PersonUtil.getInstance().getMinhchung().getProof() == "Đã có"){
            iMinhChungService.update(minhChungModel);
        }
        else{
            Long e = iMinhChungService.save(minhChungModel);
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void yeu(ActionEvent event) {
        thanh_tich.setText("Yếu");
        thanh_tichx = 4;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ho_tenText.setText(PersonUtil.getInstance().getMinhchung().getName());
    }
}
