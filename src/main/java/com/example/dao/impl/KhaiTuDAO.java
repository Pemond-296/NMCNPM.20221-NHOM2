package com.example.dao.impl;


import com.example.dao.IKhaiTuDAO;
import com.example.model.KhaiTuModel;

public class KhaiTuDAO extends AbstractDAO<KhaiTuModel> implements IKhaiTuDAO {
    public Long save (KhaiTuModel model){
        StringBuilder sql = new StringBuilder ("INSERT INTO khaitu ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), model.getId(), model.getNguoiKhaiTu(), model.getNgayKhaiTu(),
                model.getNgayQuaDoi(), model.getNguyenNhan(), model.getIdNhanKhau());
    }
}
