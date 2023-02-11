package com.example.dao.impl;

import com.example.dao.IThongKeDAO;
import com.example.mapper.ThongKeMapper;
import com.example.model.ThongKeModel;

import java.util.List;

public class ThongKeDAO extends AbstractDAO<ThongKeModel> implements IThongKeDAO {
    @Override
    public List<ThongKeModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM nhankhau LEFT JOIN hokhau on id_hokhau = hokhau.id ");
        sql.append("LEFT JOIN khaitu on nhankhau.id = khaitu.id_nhankhau ");
        sql.append("LEFT JOIN tamtru on nhankhau.id = tamtru.id_nhankhau ");
        sql.append("LEFT JOIN tamvang on nhankhau.id = tamvang.id_nhankhau ");

        return query(sql.toString(), new ThongKeMapper());
    }
}
