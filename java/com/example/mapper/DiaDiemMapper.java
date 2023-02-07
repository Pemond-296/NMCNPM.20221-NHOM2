package com.example.mapper;

import com.example.model.DiaDiemModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiaDiemMapper implements RowMapper<DiaDiemModel> {
    @Override
    public DiaDiemModel mapRow(ResultSet rs) {
        DiaDiemModel model = new DiaDiemModel();

        try {
            model.setId(rs.getLong("id"));
            model.setNgayChuyen(rs.getDate("ngay_chuyen"));
            model.setNoiChuyen(rs.getString("noi_chuyen"));
            model.setGhiChu(rs.getString("ghi_chu"));
            model.setIdNhanKhau(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
