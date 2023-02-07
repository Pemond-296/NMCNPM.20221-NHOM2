package com.example.service.impl;

import com.example.dao.IUserDAO;
import com.example.dao.impl.UserDAO;
import com.example.model.UserModel;
import com.example.service.IUserService;

public class UserService implements IUserService {
    private IUserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findByUsernameAndPassword(String username, String password, Integer status) {
        return userDAO.findByUsernameAndPassword(username, password, status);
    }
}
