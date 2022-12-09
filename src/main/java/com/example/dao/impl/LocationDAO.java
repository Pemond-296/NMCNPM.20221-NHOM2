package com.example.dao.impl;

import com.example.dao.ILocationDAO;
import com.example.model.LocationModel;

public class LocationDAO extends AbstractDAO<LocationModel> implements ILocationDAO {
    @Override
    public Long save(LocationModel locationModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO diadiem ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(), locationModel.getMoveDate(), locationModel.getMovePlace(),
                locationModel.getNote(), locationModel.getPersonId());
    }
}
