package com.example.dao;

import com.example.model.IdentifierModel;

public interface IIdentifierDAO extends GenericDAO<IdentifierModel> {
    Long save(IdentifierModel identifierModel);

}
