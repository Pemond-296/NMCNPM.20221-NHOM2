package com.example.dao.impl;


import com.example.dao.IKhaiTuDAO;
import com.example.mapper.KhaiTuMapper;
import com.example.model.KhaiTuModel;

import java.util.List;

public class KhaiTuDAO extends AbstractDAO<KhaiTuModel> implements IKhaiTuDAO {
    public Long save (KhaiTuModel model){
        StringBuilder sql = new StringBuilder ("INSERT INTO khaitu ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), model.getId(), model.getNguoiKhaiTu(), model.getNgayKhaiTu(),
                model.getNgayQuaDoi(), model.getNguyenNhan(), model.getIdNhanKhau());
    }

    @Override
    public KhaiTuModel findFirstByIdNhanKhau(Long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM khaitu ");
        sql.append("WHERE id_nhankhau = ?");
        List<KhaiTuModel> khaiTuModels =  query(sql.toString(), new KhaiTuMapper(), id);

        return khaiTuModels.isEmpty() ? null : khaiTuModels.get(0);
    }

    @Override
    public void delete(Long idNhanKhau) {
        String sql = "DELETE FROM khaitu WHERE id_nhankhau = ?";
        update(sql, idNhanKhau);
    }
}
