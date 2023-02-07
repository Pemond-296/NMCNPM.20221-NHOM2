package com.example.dao.impl;

import com.example.dao.IDinhDanhDAO;
import com.example.model.DinhDanhModel;

public class DinhDanhDAO extends AbstractDAO<DinhDanhModel> implements IDinhDanhDAO {
    @Override
    public Long save(DinhDanhModel dinhDanhModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO CMND ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(), dinhDanhModel.getSoCMT(), dinhDanhModel.getNgayCap(),
                dinhDanhModel.getNoiCap(), dinhDanhModel.getIdNhanKhau());
    }
}
