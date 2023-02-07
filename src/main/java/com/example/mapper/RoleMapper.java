package com.example.mapper;

import com.example.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet rs) {
        RoleModel model = new RoleModel();

        try {
            model.setId(rs.getLong("roleid"));
            model.setCode(rs.getString("code"));
            model.setName(rs.getString("name"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
