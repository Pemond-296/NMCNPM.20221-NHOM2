package com.example.mapper;

import com.example.model.ThongKeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeMapper implements RowMapper<ThongKeModel> {

    @Override
    public ThongKeModel mapRow(ResultSet rs) {
        ThongKeModel model = new ThongKeModel();

        try {
            model.setId(rs.getLong("id"));
            model.setHoTen(rs.getString("ho_ten"));
            model.setGioiTinh(rs.getString("gioi_tinh"));
            model.setNgaySinh(rs.getDate("ngay_sinh"));
            model.setIdHoKhau(rs.getString("id_hokhau"));
            model.setSoNha(rs.getInt("so_nha"));
            model.setTenDuong(rs.getString("ten_duong"));
            model.setPhuongXa(rs.getString("phuong_xa"));
            model.setQuanHuyen(rs.getString("quan_huyen"));

            if(model.getSoNha() != 0) {
                model.setDiaChi(model.getSoNha() + " " + model.getTenDuong() +
                        ", phường " + model.getPhuongXa() + ", quận " + model.getQuanHuyen());

            }
            else model.setDiaChi("");

            return model;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
