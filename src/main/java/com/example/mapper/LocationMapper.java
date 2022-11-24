package com.example.mapper;

import com.example.model.LocationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<LocationModel> {
    @Override
    public LocationModel mapRow(ResultSet rs) {
        LocationModel model = new LocationModel();

        try {
            model.setId(rs.getLong("id"));
            model.setMoveDate(rs.getDate("ngay_chuyen"));
            model.setMovePlace(rs.getString("noi_chuyen"));
            model.setNote(rs.getString("ghi_chu"));
            model.setPersonId(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
