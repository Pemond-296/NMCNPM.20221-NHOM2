package com.example.dao.impl;

import com.example.dao.IDiaDiemDAO;
import com.example.mapper.DiaDiemMapper;
import com.example.model.DiaDiemModel;

import java.util.List;

public class DiaDiemDAO extends AbstractDAO<DiaDiemModel> implements IDiaDiemDAO {
    @Override
    public Long save(DiaDiemModel diaDiemModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO diadiem ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(), diaDiemModel.getNgayChuyen(), diaDiemModel.getNoiChuyen(),
                diaDiemModel.getGhiChu(), diaDiemModel.getIdNhanKhau());
    }

    @Override
    public DiaDiemModel findFirstByIdNhanKhau(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM diadiem ");
        sql.append("WHERE id_nhankhau = ?");
        List<DiaDiemModel> diaDiemModels = query(sql.toString(), new DiaDiemMapper(), id);

        return diaDiemModels.isEmpty() ? null : diaDiemModels.get(0);
    }

    @Override
    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM diadiem WHERE id_nhankhau = ?";

        update(sql, idNhanKhau);
    }
}
