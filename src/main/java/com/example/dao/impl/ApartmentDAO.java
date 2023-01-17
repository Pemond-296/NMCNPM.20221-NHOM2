package com.example.dao.impl;

import com.example.dao.IApartmentDAO;
import com.example.mapper.ApartmentMapper;
import com.example.model.ApartmentModel;

import java.util.List;

public class ApartmentDAO extends AbstractDAO<ApartmentModel> implements IApartmentDAO {
    public List<ApartmentModel> findAll() {
        String sql = "SELECT * FROM hokhau";

        return query(sql, new ApartmentMapper());
    }

    @Override
    public Long save(ApartmentModel apartmentModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO hokhau ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), apartmentModel.getId(), apartmentModel.getName(), apartmentModel.getApartmentNumber(),
                                    apartmentModel.getRoadName(), apartmentModel.getWardsName(), apartmentModel.getDistrictName(),
                                    apartmentModel.getContentChanges(), apartmentModel.getDateChanges());
    }
}
