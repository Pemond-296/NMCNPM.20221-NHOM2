package com.example.mapper;

import com.example.model.DinhDanhModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DinhDanhMapper implements RowMapper<DinhDanhModel> {
    @Override
    public DinhDanhModel mapRow(ResultSet rs) {
        DinhDanhModel model = new DinhDanhModel();

        try {
            model.setId(rs.getLong("id"));
            model.setSoCMT(rs.getString("so_CMND"));
            model.setNgayCap(rs.getDate("ngay_cap"));
            model.setNoiCap(rs.getString("noi_cap"));
            model.setIdNhanKhau(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
