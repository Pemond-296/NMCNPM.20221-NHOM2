package com.example.dao.impl;

import com.example.dao.IThongKeDAO;
import com.example.mapper.ThongKeMapper;
import com.example.model.ThongKeModel;

import java.util.List;

public class ThongKeDAO extends AbstractDAO<ThongKeModel> implements IThongKeDAO {
    @Override
    public List<ThongKeModel> findAll() {
        String sql = "SELECT * FROM nhan_khau";

        List<ThongKeModel> thongKeModels = query(sql, new ThongKeMapper());
        return thongKeModels;
    }
}
