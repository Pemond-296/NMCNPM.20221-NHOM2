package com.example.dao.impl;

import com.example.dao.IGiftTableDAO;
import com.example.mapper.GiftTableMapper;
import com.example.mapper.PersonMapper;
import com.example.model.EventGiftModel;
import com.example.model.GiftTableModel;
import com.example.model.PersonModel;

import java.util.List;

public class GiftTableDAO extends AbstractDAO<GiftTableModel> implements IGiftTableDAO {
    @Override
    public List<GiftTableModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM phanthuong ");
        sql.append("INNER JOIN Qua ON Qua.idPhanQua = phanthuong.idPhanQua ");
        sql.append("INNER JOIN Dip ON Dip.idDip = phanthuong.idDip");
        sql.append("INNER JOIN (MinhChung INNER JOIN ThanhTich ON MinhChung.idThanhTich = ThanhTich.idThanhTich");
        sql.append("INNER JOIN nhankhau ON nhankhau.id = MinhChung.idNhanKhau) ON phanthuong.idMinhChung = MinhChung.idMinhChung");
        return query(sql.toString(), new GiftTableMapper());
    }

    @Override
    public GiftTableModel findByIdNhanKhau(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM phanthuong ");
        sql.append("INNER JOIN Qua ON Qua.idPhanQua = phanthuong.idPhanQua ");
        sql.append("INNER JOIN Dip ON Dip.idDip = phanthuong.idDip");
        sql.append("INNER JOIN (MinhChung INNER JOIN ThanhTich ON MinhChung.idThanhTich = ThanhTich.idThanhTich");
        sql.append("INNER JOIN nhankhau ON nhankhau.id = MinhChung.idNhanKhau) ON phanthuong.idMinhChung = MinhChung.idMinhChung");
        sql.append("WHERE MinhChung.id = ? ");
        List<GiftTableModel> models = query(sql.toString(), new GiftTableMapper(), id);
        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public List<GiftTableModel> findByDip(EventGiftModel eventGiftModel) {
        StringBuilder sql = new StringBuilder("SELECT * FROM phanthuong ");
        sql.append("INNER JOIN Qua ON Qua.idPhanQua = phanthuong.idPhanQua ");
        sql.append("INNER JOIN Dip ON Dip.idDip = phanthuong.idDip ");
        sql.append("INNER JOIN (MinhChung INNER JOIN ThanhTich ON MinhChung.idThanhTich = ThanhTich.idThanhTich ");
        sql.append("INNER JOIN nhankhau ON nhankhau.id = MinhChung.idNhanKhau) ON phanthuong.idMinhChung = MinhChung.idMinhChung ");
        sql.append("where idDip = ?");
        return query(sql.toString(), new GiftTableMapper(), eventGiftModel.getId());
    }
}
