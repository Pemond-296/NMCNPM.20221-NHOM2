package com.example.mapper;

import com.example.model.KhaiTuModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KhaiTuMapper implements RowMapper<KhaiTuModel> {
    @Override
    public KhaiTuModel mapRow(ResultSet rs) throws SQLException {
        KhaiTuModel model = new KhaiTuModel();

        try {
            model.setId(rs.getLong("id"));
            model.setNguoiKhaiTu(rs.getString("nguoi_khai_tu"));
            model.setNgayKhaiTu(rs.getDate("ngay_khai_tu"));
            model.setNgayQuaDoi(rs.getDate("ngay_qua_doi"));
            model.setNguyenNhan(rs.getString("nguyen_nhan"));
            model.setIdNhanKhau(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
