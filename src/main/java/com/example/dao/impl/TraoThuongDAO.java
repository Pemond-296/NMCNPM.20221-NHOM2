package com.example.dao.impl;

import com.example.dao.ITraoThuongDAO;
import com.example.mapper.TraoThuongMapper;
import com.example.model.GiftTableModel;
import com.example.model.MinhChungModel;
import com.example.model.TraoThuongModel;

import java.util.List;

public class TraoThuongDAO extends AbstractDAO<TraoThuongModel> implements ITraoThuongDAO {
    @Override
    public Long save(TraoThuongModel traoThuongModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO TraoThuong ");
        sql.append("VALUES (?, ?, ?)");
        return insert(sql.toString(), traoThuongModel.getId_minhChung(),
                traoThuongModel.getSo_luong(), traoThuongModel.getTrang_thai());
    }

    @Override
    public boolean findByMinhChung(GiftTableModel minhChungModel) {

        StringBuilder sql = new StringBuilder("SELECT * FROM TraoThuong tt INNER JOIN ");
        sql.append("MinhChung mc ON tt.idMinhChung = mc.idMinhChung ");
        sql.append("WHERE mc.idMinhChung = ? AND mc.idDip = ?");

        List<TraoThuongModel> traoThuongModelList = query(sql.toString(), new TraoThuongMapper(), minhChungModel.getId_minhchung(), minhChungModel.getId_dip());
        if (traoThuongModelList.isEmpty()) return false;
        return true;
    }
}
