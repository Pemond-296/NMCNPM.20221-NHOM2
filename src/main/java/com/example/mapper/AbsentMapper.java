package com.example.mapper;

import com.example.model.AbsentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsentMapper implements RowMapper<AbsentModel> {
    @Override
    public AbsentModel mapRow(ResultSet rs) {
        AbsentModel model = new AbsentModel();

        try {
            model.setId(rs.getLong(1));
            model.setDateMove(rs.getDate("ngay_di"));
            model.setDateBack(rs.getDate("ngay_ve"));
            model.setNote(rs.getString("ly_do"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
