package com.example.dao.impl;

import com.example.dao.ITamVangDAO;
import com.example.model.TamVangModel;

public class TamVangDAO extends AbstractDAO<TamVangModel> implements ITamVangDAO {

    @Override
    public Long save(TamVangModel model) {
        StringBuilder sql = new StringBuilder("INSERT INTO tamvang ");
        sql.append("VALUES (?, ?, ?, ?)");
        return insert(sql.toString(), model.getNgayDi(), model.getNgayVe(), model.getGhiChu(), model.getIdNhanKhau());
    }
}
