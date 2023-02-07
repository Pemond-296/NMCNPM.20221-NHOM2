package com.example.dao.impl;

import com.example.dao.IHoKhauDAO;
import com.example.mapper.HoKhauMapper;
import com.example.model.HoKhauModel;

import java.util.List;

public class HoKhauDAO extends AbstractDAO<HoKhauModel> implements IHoKhauDAO {
    public List<HoKhauModel> findAll() {
        String sql = "SELECT * FROM hokhau";

        return query(sql, new HoKhauMapper());
    }

    @Override
    public Long save(HoKhauModel hoKhauModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO hokhau ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), hoKhauModel.getId(), hoKhauModel.getTenChuHo(), hoKhauModel.getSoNha(),
                                    hoKhauModel.getTenDuong(), hoKhauModel.getPhuongXa(), hoKhauModel.getQuanHuyen(),
                                    hoKhauModel.getNoiDungThayDoi(), hoKhauModel.getThoiGianThayDoi());
    }
}
