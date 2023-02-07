package com.example.mapper;

import com.example.model.ThongKeTTModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeTTMapper implements RowMapper<ThongKeTTModel>{

    @Override
    public ThongKeTTModel mapRow(ResultSet rs) {
        ThongKeTTModel thongKeTTModel = new ThongKeTTModel();

        try {

            thongKeTTModel.setTen_chu_ho(rs.getString("ten_chu_ho"));
            thongKeTTModel.setPhan_qua(rs.getString("ten_phan_thuong"));
            thongKeTTModel.setTien(rs.getInt("tien"));
            thongKeTTModel.setSo_Luong(rs.getInt("so_luong"));

            return thongKeTTModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

