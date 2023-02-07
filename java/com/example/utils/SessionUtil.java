package com.example.utils;

import com.example.model.UserModel;

public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    private UserModel data = null;

    public static SessionUtil getInstance() {
        if (sessionUtil == null) sessionUtil = new SessionUtil();

        return sessionUtil;
    }

    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }

    public void removeData() {
        setData(null);
    }
}
