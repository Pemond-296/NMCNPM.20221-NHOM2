package com.example.dao.impl;

import com.example.dao.IPersonDAO;
import com.example.mapper.PersonMapper;
import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.PersonModel;

import java.util.List;

public class PersonDAO extends AbstractDAO<PersonModel> implements IPersonDAO {

    @Override
    public List<PersonModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau");
        return query(sql.toString(), new PersonMapper());
    }

    @Override
    public PersonModel findById(Long id) {
        String sql = "SELECT * FROM nhankhau WHERE id = ?";
        List<PersonModel> models = query(sql, new PersonMapper(), id);

        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public Long save(PersonModel personModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO nhankhau ([ho_ten], [dan_toc], [ngay_sinh], ");
        sql.append("nguyen_quan, gioi_tinh, nghe_nghiep, noi_lam_viec, bi_danh, dia_chi_thuong_tru, ngay_dk_thuong_tru) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        return insert(sql.toString(), personModel.getName(), personModel.getEthnic(), personModel.getBirthDate(),
                personModel.getHometown(), personModel.getGender(), personModel.getJob(), personModel.getWorkPlace(),
                personModel.getNickname(), personModel.getRegisterPlace(), personModel.getRegisterDate());
    }

    @Override
    public List<PersonModel> findMonitor() {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau ");
        sql.append("INNER JOIN CMND ON nhankhau.id = CMND.id_nhankhau ");
        sql.append("INNER JOIN diadiem ON nhankhau.id = diadiem.id_nhankhau ");
        sql.append("WHERE id_hokhau IS NULL");
        return query(sql.toString(), new PersonMapper());
    }

    @Override
    public void update(PersonModel personModel) {
        StringBuilder sql = new StringBuilder("UPDATE nhankhau SET id_hokhau = ?");

        update(sql.toString(), personModel.getApartmentId());
    }

    @Override
    public List<PersonModel> findByAge() {
//        Year y = Year.now();
//        int year = y.getValue();
        String sql = "SELECT * FROM nhankhau";
//        sql.append("WHERE YEAR()")
        return query(sql.toString(), new PersonMapper());
    }

    @Override
    public List<PersonModel> findByProof(MinhChungModel  minhChungModel) {

        String sql = "SELECT * FROM nhankhau nk WHERE nk.id = ?";

        return query(sql, new PersonMapper(), minhChungModel.getId_nhan_khau());
    }

    @Override
    public List<PersonModel> findNotProof(EventGiftModel eventGiftModel) {

        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau WHERE id NOT IN ");
        sql.append("(SELECT idNhanKhau FROM MinhChung WHERE idDip = ? )");

        return query(sql.toString(), new PersonMapper(), eventGiftModel.getId());

    }
}
