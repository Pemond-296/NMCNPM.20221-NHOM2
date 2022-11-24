package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    @FXML
    private AnchorPane application;
    @FXML
    private MenuButton tra_cuu;

    @FXML
    private MenuItem ho_khau;

    @FXML
    private MenuItem nhan_khau;

    @FXML
    private Button them_nhan_khau;

    @FXML
    private Button doi_thong_tin_NK;

    @FXML
    private Button tach_ho;

    @FXML
    private Button doi_thong_tin_HK;

    @FXML
    private Button cap_giay;

    @FXML
    private Button thong_ke;

    @FXML
    private Button close;

    public void tra_cuu(ActionEvent actionEvent){
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(this.getClass().getResource("Information.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        application.getChildren().add(rootChild);


    }

    public void ho_khau(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void nhan_khau(ActionEvent actionEvent){
        System.out.println("oke");
    }


    public void them_nhan_khau(ActionEvent actionEvent){
        application.getChildren().clear();
        Parent rootChild = null;
        try {
            rootChild = FXMLLoader.load(this.getClass().getResource("AddPerson.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        application.getChildren().add(rootChild);


    }

    public void doi_thong_tin_NK(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void doi_thong_tin_HK(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void tach_ho(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void cap_giay(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void thong_ke(ActionEvent actionEvent){
        System.out.println("oke");
    }
    public void close(ActionEvent actionEvent){
        System.out.println("oke");
    }



}
