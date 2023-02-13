package com.example.dao.impl;

import com.example.dao.ITamVangDAO;
import com.example.mapper.TamVangMapper;
import com.example.model.TamVangModel;

import java.util.List;

public class TamVangDAO extends AbstractDAO<TamVangModel> implements ITamVangDAO {

    @Override
    public Long save(TamVangModel model) {
        StringBuilder sql = new StringBuilder("INSERT INTO tamvang ");
        sql.append("VALUES (?, ?, ?, ?)");
        return insert(sql.toString(), model.getNgayDi(), model.getNgayVe(), model.getGhiChu(), model.getIdNhanKhau());
    }

    @Override
    public TamVangModel findFirstByNhanKhauId(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tamvang ");
        sql.append("WHERE id_nhankhau = ?");
        List<TamVangModel> tamVangModels = query(sql.toString(), new TamVangMapper(), id);

        return tamVangModels.isEmpty() ? null : tamVangModels.get(0);
    }

    @Override
    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM tamvang WHERE id_nhankhau = ?";

        update(sql,idNhanKhau);
    }

    @Override
    public Long count() {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM tamvang");

        return count(sql.toString());
    }
}
