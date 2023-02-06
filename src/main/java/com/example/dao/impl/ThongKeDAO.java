package com.example.dao.impl;

import com.example.dao.IThongKeDAO;
import com.example.mapper.ThongKeMapper;
import com.example.model.ThongKeModel;

import java.util.List;

public class ThongKeDAO extends AbstractDAO<ThongKeModel> implements IThongKeDAO {
    @Override
    public List<ThongKeModel> findAll() {
        String sql = "SELECT * FROM nhankhau LEFT JOIN hokhau on id_hokhau = hokhau.id";

        return query(sql, new ThongKeMapper());
    }
}
