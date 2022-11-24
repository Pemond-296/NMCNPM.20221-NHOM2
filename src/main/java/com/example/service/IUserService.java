package com.example.service;

import com.example.model.UserModel;

public interface IUserService {
    UserModel findByUsernameAndPassword(String username, String password, Integer status);

}
