package com.example.dao.impl;

import com.example.dao.INhanKhauDAO;
import com.example.mapper.NhanKhauMapper;
import com.example.model.NhanKhauModel;

import java.util.List;

public class NhanKhauDAO extends AbstractDAO<NhanKhauModel> implements INhanKhauDAO {

    @Override
    public List<NhanKhauModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau");
        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public NhanKhauModel findById(Long id) {
        String sql = "SELECT * FROM nhankhau WHERE id = ?";
        List<NhanKhauModel> models = query(sql, new NhanKhauMapper(), id);

        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public Long save(NhanKhauModel nhanKhauModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO nhankhau ([ho_ten], [dan_toc], [ngay_sinh], ");
        sql.append("nguyen_quan, gioi_tinh, nghe_nghiep, noi_lam_viec, bi_danh, dia_chi_thuong_tru, ngay_dk_thuong_tru) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        return insert(sql.toString(), nhanKhauModel.getHoTen(), nhanKhauModel.getDanToc(), nhanKhauModel.getNgaySinh(),
                nhanKhauModel.getNguyenQuan(), nhanKhauModel.getGioiTinh(), nhanKhauModel.getCongViec(), nhanKhauModel.getNoiLamViec(),
                nhanKhauModel.getBiDanh(), nhanKhauModel.getNoiDkiThuongTru(), nhanKhauModel.getNgayDkiThuongTru());
    }

    @Override
    public List<NhanKhauModel> findMonitor() {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        sql.append("WHERE id_hokhau IS NULL");
        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public List<NhanKhauModel> findAllByApartmentId(String id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        sql.append("WHERE id_hokhau = '");
        sql.append(id);
        sql.append("'");

        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public void update(NhanKhauModel nhanKhauModel) {
        StringBuilder sql = new StringBuilder("UPDATE nhankhau SET id_hokhau = ?, quan_he = ? ");
        sql.append("WHERE id = ?");

        update(sql.toString(), nhanKhauModel.getIdHoKhau(), nhanKhauModel.getQuanHe(), nhanKhauModel.getId());
    }
}
