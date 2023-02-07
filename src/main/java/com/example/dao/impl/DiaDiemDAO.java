package com.example.dao.impl;

import com.example.dao.IDiaDiemDAO;
import com.example.model.DiaDiemModel;

public class DiaDiemDAO extends AbstractDAO<DiaDiemModel> implements IDiaDiemDAO {
    @Override
    public Long save(DiaDiemModel diaDiemModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO diadiem ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(), diaDiemModel.getNgayChuyen(), diaDiemModel.getNoiChuyen(),
                diaDiemModel.getGhiChu(), diaDiemModel.getIdNhanKhau());
    }
}
