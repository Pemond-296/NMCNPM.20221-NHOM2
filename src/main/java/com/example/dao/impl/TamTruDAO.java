package com.example.dao.impl;

import com.example.dao.ITamTruDAO;
import com.example.mapper.TamTruMapper;
import com.example.model.TamTruModel;

import java.util.List;

public class TamTruDAO extends AbstractDAO<TamTruModel> implements ITamTruDAO {
    @Override
    public Long save(TamTruModel model) {
        StringBuilder sql = new StringBuilder("INSERT INTO tamtru ");
        sql.append("VALUES (?, ?, ?, ?)");
        return insert(sql.toString(), model.getTuNgay(), model.getDenNgay(), model.getLyDo(), model.getIdNhanKhau());
    }

    @Override
    public TamTruModel findFirstByNhanKhauId(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tamtru ");
        sql.append("WHERE id_nhankhau = ?");
        List<TamTruModel> tamTruModels = query(sql.toString(), new TamTruMapper(), id);

        return tamTruModels.isEmpty() ? null : tamTruModels.get(0);
    }

    @Override
    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM tamtru WHERE id_nhankhau = ?";

        update(sql, idNhanKhau);
    }

    @Override
    public Long count() {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM tamtru");

        return count(sql.toString());
    }
}
