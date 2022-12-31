package com.example.mapper;

import com.example.model.GiftTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GiftTableMapper implements RowMapper<GiftTableModel>{
    @Override
    public GiftTableModel mapRow(ResultSet rs) {
        GiftTableModel model = new GiftTableModel();
        try {
            model.setTen_dip(rs.getString("TenDip"));
            model.setSo_luong(rs.getInt("SoLuong"));
            model.setTen_nhan_khau(rs.getString("ho_ten"));
            model.setTen_phan_qua(rs.getString("TenQua"));
            model.setTen_thanh_tich(rs.getString("TenThanhTich"));
            model.setNgay_thang(rs.getDate("dateDip"));
            model.setTen_doi_tuong(rs.getString("TenDoiTuong"));
            model.setSo_thu_tu(rs.getInt("idMinhChung"));
            model.setTien_phan_qua(rs.getInt("Tien"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
