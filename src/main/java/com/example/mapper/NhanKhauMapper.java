package com.example.mapper;

import com.example.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanKhauMapper implements RowMapper<NhanKhauModel> {
    @Override
    public NhanKhauModel mapRow(ResultSet rs){
        NhanKhauModel model = new NhanKhauModel();
        TamTruModel tamTruModel = new TamTruModel();
        TamVangModel tamVangModel = new TamVangModel();
        KhaiTuModel khaiTuModel = new KhaiTuModel();
        DiaDiemModel diaDiemModel = new DiaDiemModel();

        try {
            model.setId(rs.getLong("id"));
            model.setHoTen(rs.getString("ho_ten"));
            model.setBiDanh(rs.getString("bi_danh"));
            model.setGioiTinh(rs.getString("gioi_tinh"));
            model.setNgaySinh(rs.getDate("ngay_sinh"));
            model.setNoiSinh(rs.getString("noi_sinh"));
            model.setNguyenQuan(rs.getString("nguyen_quan"));
            model.setDanToc(rs.getString("dan_toc"));
            model.setCongViec(rs.getString("nghe_nghiep"));
            model.setNoiLamViec(rs.getString("noi_lam_viec"));
            model.setNgayDkiThuongTru(rs.getDate("ngay_dk_thuong_tru"));
            model.setNoiDkiThuongTru(rs.getString("dia_chi_thuong_tru"));
            model.setNoiOTruoc(rs.getString("dia_chi_truoc"));
            model.setQuanHe(rs.getString("quan_he"));
            model.setIdHoKhau(rs.getString("id_hokhau"));

            DinhDanhModel dinhDanhModel = new DinhDanhMapper().mapRow(rs);
//            DiaDiemModel diaDiemModel = new DiaDiemMapper().mapRow(rs);

            model.setIdentifierModel(dinhDanhModel);
//            model.setLocationModel(diaDiemModel);
            model.setSoCMT(dinhDanhModel.getSoCMT());

            tamTruModel.setTuNgay(rs.getDate("tu_ngay"));
            tamVangModel.setNgayDi(rs.getDate("ngay_ve"));
            khaiTuModel.setNguoiKhaiTu(rs.getString("nguoi_khai_tu"));
            diaDiemModel.setNoiChuyen(rs.getString("noi_chuyen"));

            model.setTamTruModel(tamTruModel);
            model.setTamVangModel(tamVangModel);
            model.setKhaiTuModel(khaiTuModel);
            model.setDiaDiemModel(diaDiemModel);

            return model;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
