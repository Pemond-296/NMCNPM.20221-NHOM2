package com.example.dao.impl;

import com.example.dao.GenericDAO;
import com.example.dao.IApartmentDAO;
import com.example.mapper.ApartmentMapper;
import com.example.model.ApartmentModel;

import java.util.List;

public class ApartmentDAO extends AbstractDAO<ApartmentModel> implements IApartmentDAO {
    public List<ApartmentModel> findAll() {
        String sql = "SELECT * FROM hokhau";

        return query(sql, new ApartmentMapper());
    }
}
