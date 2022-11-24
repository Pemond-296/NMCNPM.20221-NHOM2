package com.example.controller;

import com.example.model.UserModel;
import com.example.service.IUserService;
import com.example.service.impl.UserService;
import com.example.utils.SessionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;

    private IUserService userService = new UserService();

    public void login(ActionEvent actionEvent) throws IOException {
        String user = username.getText();
        String pass = password.getText();

        if(user.equals("") || pass.equals("")) {
            System.out.println("Ban chua dang nhap");
            return;
        }

        UserModel model = userService.findByUsernameAndPassword(user, pass, 1);

        if (model != null) {
            if (model.getRoleModel().getCode().equals("ADMIN")) {
                SessionUtil.getInstance().setData(model);

                Parent root = FXMLLoader.load(HomeController.class.getResource("Home.fxml"));
                Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(String.valueOf(HomeController.class.getResource("home.css")));
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }

            else {
                System.out.println("Ban la user");
            }
        }

        else {
            System.out.println("Tai khoan khong ton tai");
        }

    }
}
