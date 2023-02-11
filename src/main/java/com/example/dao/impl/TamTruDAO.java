package com.example.dao.impl;

import com.example.dao.ITamTruDAO;
import com.example.model.TamTruModel;

public class TamTruDAO extends AbstractDAO<TamTruModel> implements ITamTruDAO {
    @Override
    public Long save(TamTruModel model) {
        StringBuilder sql = new StringBuilder("INSERT INTO tamtru ");
        sql.append("VALUES (?, ?, ?, ?)");
        return insert(sql.toString(), model.getTuNgay(), model.getDenNgay(), model.getLyDo(), model.getIdNhanKhau());
    }
}
