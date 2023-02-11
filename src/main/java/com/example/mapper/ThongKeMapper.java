package com.example.mapper;

import com.example.model.KhaiTuModel;
import com.example.model.TamTruModel;
import com.example.model.TamVangModel;
import com.example.model.ThongKeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeMapper implements RowMapper<ThongKeModel> {

    @Override
    public ThongKeModel mapRow(ResultSet rs) {
        ThongKeModel model = new ThongKeModel();
        KhaiTuModel khaiTuModel = new KhaiTuModel();
        TamTruModel tamTruModel = new TamTruModel();
        TamVangModel tamVangModel = new TamVangModel();

        try {
            model.setId(rs.getLong(1));
            model.setHoTen(rs.getString("ho_ten"));
            model.setGioiTinh(rs.getString("gioi_tinh"));
            model.setNgaySinh(rs.getDate("ngay_sinh"));
            model.setIdHoKhau(rs.getString("id_hokhau"));
            model.setSoNha(rs.getInt("so_nha"));
            model.setTenDuong(rs.getString("ten_duong"));
            model.setPhuongXa(rs.getString("phuong_xa"));
            model.setQuanHuyen(rs.getString("quan_huyen"));

            khaiTuModel.setNguoiKhaiTu(rs.getString("nguoi_khai_tu"));
            tamTruModel.setTuNgay(rs.getDate("tu_ngay"));
            tamVangModel.setNgayDi(rs.getDate("ngay_di"));

            model.setKhaiTuModel(khaiTuModel);
            model.setTamTruModel(tamTruModel);
            model.setTamVangModel(tamVangModel);

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
