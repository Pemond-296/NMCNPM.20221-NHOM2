package com.example.mapper;

import com.example.model.TamVangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamVangMapper implements RowMapper<TamVangModel> {
    @Override
    public TamVangModel mapRow(ResultSet rs) {
        TamVangModel model = new TamVangModel();

        try {
            model.setId(rs.getLong(1));
            model.setNgayDi(rs.getDate("ngay_di"));
            model.setNgayVe(rs.getDate("ngay_ve"));
            model.setGhiChu(rs.getString("ly_do"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
