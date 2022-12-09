package com.example.dao.impl;

import com.example.dao.IAbsentDAO;
import com.example.model.AbsentModel;

public class AbsentDAO extends AbstractDAO<AbsentModel> implements IAbsentDAO {

    @Override
    public Long save(AbsentModel model) {
        StringBuilder sql = new StringBuilder("INSERT INTO tamvang ");
        sql.append("VALUES (?, ?, ?, ?)");
        return insert(sql.toString(), model.getDateMove(), model.getDateBack(), model.getNote(), model.getPersonId());
    }
}
