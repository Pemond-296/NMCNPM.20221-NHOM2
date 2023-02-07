package com.example.mapper;

import com.example.model.HoKhauModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoKhauMapper implements RowMapper<HoKhauModel> {
    @Override
    public HoKhauModel mapRow(ResultSet rs) {
    HoKhauModel model = new HoKhauModel();
        try {
            model.setId(rs.getString("id"));
            model.setTenChuHo(rs.getString("ten_chu_ho"));
            model.setSoNha(rs.getInt("so_nha"));
            model.setTenDuong(rs.getString("ten_duong"));
            model.setPhuongXa(rs.getString("phuong_xa"));
            model.setQuanHuyen(rs.getString("quan_huyen"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
