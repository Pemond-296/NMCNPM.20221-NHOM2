package com.example.mapper;

import com.example.model.ApartmentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentMapper implements RowMapper<ApartmentModel> {
    @Override
    public ApartmentModel mapRow(ResultSet rs) {
    ApartmentModel model = new ApartmentModel();
        try {
            model.setId(rs.getString("id"));
            model.setName(rs.getString("ten_chu_ho"));
            model.setApartmentNumber(rs.getInt("so_nha"));
            model.setRoadName(rs.getString("ten_duong"));
            model.setWardsName(rs.getString("phuong_xa"));
            model.setDistrictName(rs.getString("quan_huyen"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
