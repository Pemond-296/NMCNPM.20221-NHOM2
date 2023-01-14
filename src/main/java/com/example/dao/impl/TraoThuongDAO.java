package com.example.dao.impl;

import com.example.dao.ITraoThuongDAO;
import com.example.model.TraoThuongModel;

public class TraoThuongDAO extends AbstractDAO<TraoThuongModel> implements ITraoThuongDAO {
    @Override
    public Long save(TraoThuongModel traoThuongModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO TraoThuong ");
        sql.append("VALUES (?, ?, ?)");
        return insert(sql.toString(), traoThuongModel.getId_minhChung(),
                traoThuongModel.getSo_luong(), traoThuongModel.getTrang_thai());
    }
}
