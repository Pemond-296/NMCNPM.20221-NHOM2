package com.example.controller;

import com.example.model.*;
import com.example.service.IMinhChungService;
import com.example.service.INhanKhauService;
import com.example.service.ITraoThuongService;
import com.example.service.impl.MinhChungService;
import com.example.service.impl.NhanKhauService;
import com.example.service.impl.TraoThuongService;
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
import javafx.scene.control.Label;
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

public class LapDanhSachController implements Initializable {

    IMinhChungService minhChungService = new MinhChungService();
    INhanKhauService nhanKhauService = new NhanKhauService();
    @FXML
    private TableView<GiftTableModel> danh_sachTable;

    @FXML
    private TableColumn<?, ?> ho_ten;

    @FXML
    private TableColumn<?, ?> ngay_thang;

    @FXML
    private TableColumn<?, ?> thanh_tich;

    @FXML
    private TableColumn<?, ?> qua;

    @FXML
    private TableColumn<?, ?> so_luong;

    @FXML
    private TableColumn<?, ?> stt;

    @FXML
    private TextField tim_kiemText;

    @FXML
    private TableColumn<?, ?> trang_thai;
    List<GiftTableModel> giftTableModelList = new ArrayList<>();
    EventGiftModel eventGiftModel = DipUtil.getInstance().getData();
    private ITraoThuongService iTraoThuongService = new TraoThuongService();
    @FXML
    void save(ActionEvent event) {
        for (GiftTableModel giftTableModel : giftTableModelList){
            TraoThuongModel traoThuongModel = new TraoThuongModel();
            traoThuongModel.setSo_luong(giftTableModel.getSo_luong());
            traoThuongModel.setId_phanQua(eventGiftModel.getIdQua());
            if(giftTableModel.getTrang_thai() == "Đã trao"){
                traoThuongModel.setTrang_thai(1);
            }
            else traoThuongModel.setTrang_thai(0);
            traoThuongModel.setId_minhChung(giftTableModel.getId_minhchung());

            if (iTraoThuongService.findByMinhChung(giftTableModel) == true){

            }
            else{
                Long e = iTraoThuongService.save(traoThuongModel);
            }

        }
    }
    @FXML
    private Label ten_dip;
    @FXML
    void tim_kiem(ActionEvent event) {

    }
    ObservableList<GiftTableModel> observableList = FXCollections.observableArrayList(getMember());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ten_dip.setText("DANH SÁCH TRAO THƯỞNG DỊP: " + DipUtil.getInstance().getData().getNameEvent());
        ho_ten.setCellValueFactory(new PropertyValueFactory<>("ten_nhan_khau"));
        ngay_thang.setCellValueFactory(new PropertyValueFactory<>("ngay_thang"));
        thanh_tich.setCellValueFactory(new PropertyValueFactory<>("ten_thanh_tich"));
        qua.setCellValueFactory(new PropertyValueFactory<>("ten_phan_qua"));
        so_luong.setCellValueFactory(new PropertyValueFactory<>("so_luong"));
        trang_thai.setCellValueFactory(new PropertyValueFactory<>("trang_thai"));
        danh_sachTable.setItems(observableList);
    }
    List<GiftTableModel> getMember(){
        giftTableModelList.clear();
        List<MinhChungModel> minhChungModels = minhChungService.findByDip(eventGiftModel);
        if(eventGiftModel.getLoai_dip() == 0) {
            if (minhChungModels != null) {
                for (MinhChungModel minhChungModel : minhChungModels) {

                    NhanKhauModel nhanKhauModel = nhanKhauService.findById(minhChungModel.getId_nhan_khau());

                    GiftTableModel giftTableModel = new GiftTableModel();
                    giftTableModel.setTen_nhan_khau(nhanKhauModel.getHoTen());
                    giftTableModel.setNgay_thang(eventGiftModel.getDate());
                    giftTableModel.setTen_dip(eventGiftModel.getNameEvent());
                    giftTableModel.setId_minhchung(minhChungModel.getId());
                    giftTableModel.setId_dip(minhChungModel.getId_dip());

                    if(iTraoThuongService.findByMinhChung(giftTableModel)){
                        giftTableModel.setTrang_thai("Đã trao");
                    }
                    else{
                        giftTableModel.setTrang_thai("Chưa trao");
                    }
                    if (minhChungModel.getId_thanhtich() == 1) { // trẻ em
                        giftTableModel.setTen_thanh_tich("Trẻ dưới 18");
                        giftTableModel.setSo_luong(1);
                        giftTableModel.setTen_doi_tuong("Trẻ dưới 18");
                        giftTableModel.setTen_phan_qua("Bánh, kẹo");

                    }
                    giftTableModelList.add(giftTableModel);
                }
            }
        }
        else{
            if(minhChungModels != null){
                for(MinhChungModel minhChungModel : minhChungModels){
                    List<NhanKhauModel> nhanKhauModels = nhanKhauService.findByProof(minhChungModel);
                    GiftTableModel giftTableModel = new GiftTableModel();
                    giftTableModel.setTen_nhan_khau(nhanKhauModels.get(0).getHoTen());
                    giftTableModel.setTen_dip(eventGiftModel.getNameEvent());
                    giftTableModel.setNgay_thang(eventGiftModel.getDate());
                    giftTableModel.setId_minhchung(minhChungModel.getId());
                    giftTableModel.setTen_phan_qua("Sach, vo");
                    giftTableModel.setTen_doi_tuong("hoc sinh");
                    giftTableModel.setId_dip(minhChungModel.getId_dip());

                    if(iTraoThuongService.findByMinhChung(giftTableModel)){
                        giftTableModel.setTrang_thai("Đã trao");
                    }
                    else{
                        giftTableModel.setTrang_thai("Chưa trao");
                    }
                    if(minhChungModel.getId_thanhtich() == 2){ // hoc sinh gioi
                        giftTableModel.setSo_luong(10);
                        giftTableModel.setTen_thanh_tich("Gioi");
                    }
                    else if(minhChungModel.getId_thanhtich() == 3) { // hoc sinh kha
                        giftTableModel.setSo_luong(7);
                        giftTableModel.setTen_thanh_tich("Trung binh");
                    } else if (minhChungModel.getId_thanhtich() == 4) { // yeu
                        giftTableModel.setSo_luong(5);
                        giftTableModel.setTen_thanh_tich("Yeu");
                    }
                    giftTableModelList.add(giftTableModel);
                }
            }
        }
    return giftTableModelList;
    }

    @FXML
    void trao_thuong(ActionEvent event){
        GiftTableModel giftTableModel = danh_sachTable.getSelectionModel().getSelectedItem();
        if (giftTableModel.getTrang_thai() == "Đã trao"){
            System.out.println("Trao rồi mà a zai, tham lam!");
        }
        else{

            giftTableModel.setTrang_thai("Đã trao");
            TraoThuongModel traoThuongModel = new TraoThuongModel();
            traoThuongModel.setId_minhChung(giftTableModel.getId_minhchung());
            traoThuongModel.setTrang_thai(1);
            traoThuongModel.setSo_luong(giftTableModel.getSo_luong());
            Long e = iTraoThuongService.save(traoThuongModel);

            observableList.clear();
            observableList.addAll(getMember());
            danh_sachTable.setItems(observableList);
        }
    }

    @FXML
    void chon_dip(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(TaoMoiDipController.class.getResource("ChonDip.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage1.close();
    }

}
