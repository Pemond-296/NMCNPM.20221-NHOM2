package com.example.dao.impl;

import com.example.dao.IUserDAO;
import com.example.mapper.UserMapper;
import com.example.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public UserModel findByUsernameAndPassword(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM [user] AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE [username] = ? AND [password] = ? and [status] = ?");

        List<UserModel> users = query(sql.toString(), new UserMapper(), username, password, status);

        return users.isEmpty() ? null : users.get(0);
    }
}
