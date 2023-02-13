package com.example.dao.impl;

import com.example.dao.INhanKhauDAO;
import com.example.mapper.NhanKhauMapper;
import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;

import java.time.Year;
import java.util.List;

public class NhanKhauDAO extends AbstractDAO<NhanKhauModel> implements INhanKhauDAO {

    @Override
    public List<NhanKhauModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT nhankhau.*, CMND.* FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("LEFT JOIN tamtru ON nhankhau.id = tamtru.id_nhankhau ");
        sql.append("LEFT JOIN tamvang ON nhankhau.id = tamvang.id_nhankhau ");
        sql.append("LEFT JOIN khaitu ON nhankhau.id = khaitu.id_nhankhau ");
        sql.append("LEFT JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public NhanKhauModel findById(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("WHERE nhankhau.id = ?");
        List<NhanKhauModel> models = query(sql.toString(), new NhanKhauMapper(), id);

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
        sql.append("LEFT JOIN tamtru ON nhankhau.id = tamtru.id_nhankhau ");
        sql.append("LEFT JOIN tamvang ON nhankhau.id = tamvang.id_nhankhau ");
        sql.append("LEFT JOIN khaitu ON nhankhau.id = khaitu.id_nhankhau ");
        sql.append("LEFT JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        sql.append("WHERE id_hokhau IS NULL AND tamtru.id IS NULL AND khaitu.id IS NULL AND diadiem.id IS NULL");
        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public List<NhanKhauModel> findAllByApartmentId(String id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
//        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        sql.append("WHERE id_hokhau = '");
        sql.append(id);
        sql.append("' ");
        sql.append("ORDER BY CASE WHEN quan_he = N'Chủ hộ' THEN 0 ELSE 1 END");

        return query(sql.toString(), new NhanKhauMapper());
    }

    @Override
    public void update(NhanKhauModel nhanKhauModel) {
        StringBuilder sql = new StringBuilder("UPDATE nhankhau SET id_hokhau = ?, quan_he = ? ");
        sql.append("WHERE id = ?");

        update(sql.toString(), nhanKhauModel.getIdHoKhau(), nhanKhauModel.getQuanHe(), nhanKhauModel.getId());
    }

    @Override
    public void updateInfo(NhanKhauModel nhanKhauModel) {
        StringBuilder sql = new StringBuilder("UPDATE nhankhau SET ho_ten = ?, bi_danh = ?, ");
        sql.append("gioi_tinh = ?, ngay_sinh = ?, nguyen_quan = ?, dan_toc = ?, nghe_nghiep = ?, ");
        sql.append("noi_lam_viec = ?, ngay_dk_thuong_tru = ?, dia_chi_thuong_tru = ? ");
        sql.append("WHERE id = ?");

        update(sql.toString(), nhanKhauModel.getHoTen(), nhanKhauModel.getBiDanh(),
                nhanKhauModel.getGioiTinh(), nhanKhauModel.getNgaySinh(), nhanKhauModel.getNguyenQuan(),
                nhanKhauModel.getDanToc(), nhanKhauModel.getCongViec(), nhanKhauModel.getNoiLamViec(),
                nhanKhauModel.getNgayDkiThuongTru(), nhanKhauModel.getNoiDkiThuongTru(), nhanKhauModel.getId());
    }

    @Override
    public Long count() {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM nhankhau");

        return count(sql.toString());
    }

    @Override
    public List<NhanKhauModel> findByAge() {
        Year y = Year.now();
        Integer year = y.getValue();
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append(" INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
//        sql.append(" INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau");
        sql.append(" WHERE (? - YEAR(ngay_sinh)) between 0 and 18");
        return query(sql.toString(), new NhanKhauMapper(), year);
    }

    @Override
    public List<NhanKhauModel> findByProof(MinhChungModel minhChungModel) {

        String sql = "SELECT * FROM nhankhau" +
                " INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau " +
//                " INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau" +
                "  WHERE nhankhau.id = ?";

        return query(sql, new NhanKhauMapper(), minhChungModel.getId_nhan_khau());
    }

    @Override
    public List<NhanKhauModel> findNotProof(EventGiftModel eventGiftModel) {

        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau" +
//                " INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau" +
                "  INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau" +
                " WHERE nhankhau.id NOT IN ");
        sql.append("(SELECT idNhanKhau FROM MinhChung WHERE idDip = ? )");

        return query(sql.toString(), new NhanKhauMapper(), eventGiftModel.getId());

    }

    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM nhankhau WHERE id = ?";

        update(sql, idNhanKhau);
    }
}
