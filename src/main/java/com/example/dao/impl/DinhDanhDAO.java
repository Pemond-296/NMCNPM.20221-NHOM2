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

    @Override
    public void update(DinhDanhModel dinhDanhModel) {
        StringBuilder sql = new StringBuilder("UPDATE CMND SET so_CMND = ? ");
        sql.append("WHERE id_nhankhau = ?");

        update(sql.toString(), dinhDanhModel.getSoCMT(), dinhDanhModel.getIdNhanKhau());
    }

    @Override
    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM CMND WHERE id_nhankhau = ?";

        update(sql, idNhanKhau);
    }
}
