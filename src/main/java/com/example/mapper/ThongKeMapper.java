package com.example.mapper;

import com.example.model.ThongKeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeMapper implements RowMapper<ThongKeModel>{

    @Override
    public ThongKeModel mapRow(ResultSet rs) {
        ThongKeModel thongKeModel = new ThongKeModel();

        try {

            thongKeModel.setTen_chu_ho(rs.getString("ten_chu_ho"));
            thongKeModel.setPhan_qua(rs.getString("ten_phan_thuong"));
            thongKeModel.setTien(rs.getInt("tien"));
            thongKeModel.setSo_Luong(rs.getInt("so_luong"));

            return thongKeModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

