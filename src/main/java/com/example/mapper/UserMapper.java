package com.example.mapper;

import com.example.model.RoleModel;
import com.example.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel model = new UserModel();

        try {
            model.setId(rs.getLong(1));
            model.setUserName(rs.getString("username"));
            model.setPassword(rs.getString("password"));
            model.setFullName(rs.getString("fullname"));
            model.setStatus(rs.getInt("status"));

//            try {
//                RoleModel role = new RoleModel();
//                role.setId(rs.getLong("roleid"));
//                role.setCode(rs.getString("code"));
//                role.setName(rs.getString("name"));
//                model.setRoleModel(role);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            RoleModel role = new RoleMapper().mapRow(rs);
            model.setRoleModel(role);

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
