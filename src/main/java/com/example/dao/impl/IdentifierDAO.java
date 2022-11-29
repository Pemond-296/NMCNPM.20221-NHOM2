package com.example.dao.impl;

import com.example.dao.IIdentifierDAO;
import com.example.model.IdentifierModel;

public class IdentifierDAO extends AbstractDAO<IdentifierModel> implements IIdentifierDAO {
    @Override
    public Long save(IdentifierModel identifierModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO CMND ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(), identifierModel.getIdentityNumber(), identifierModel.getCardReleaseDate(),
                identifierModel.getCardReleasePlace(), identifierModel.getPersonId());
    }
}
