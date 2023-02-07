package com.example.mapper;

import com.example.model.TraoThuongModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TraoThuongMapper implements RowMapper<TraoThuongModel> {
    TraoThuongModel traoThuongModel = new TraoThuongModel();
    @Override
    public TraoThuongModel mapRow(ResultSet rs) throws SQLException {

        traoThuongModel.setId_minhChung(rs.getLong("idMinhChung"));
        traoThuongModel.setSo_luong(rs.getInt("so_luong"));
        traoThuongModel.setTrang_thai(rs.getInt("trang_thai"));
        return traoThuongModel;
    }
}
