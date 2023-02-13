package com.example.mapper;

import com.example.model.TamTruModel;
import com.example.model.TamVangModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamTruMapper implements RowMapper<TamTruModel> {
    @Override
    public TamTruModel mapRow(ResultSet rs) {
        TamTruModel model = new TamTruModel();

        try {
            model.setId(rs.getLong(1));
            model.setTuNgay(rs.getDate("tu_ngay"));
            model.setDenNgay(rs.getDate("den_ngay"));
            model.setLyDo(rs.getString("ly_do"));
            model.setIdNhanKhau(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
