package com.example.controller;

import com.example.model.UserModel;
import com.example.service.IUserService;
import com.example.service.impl.UserService;
import com.example.utils.SessionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;

    private IUserService userService = new UserService();

    public void login(ActionEvent actionEvent) {
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
                System.out.println("Ban la admin");
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
