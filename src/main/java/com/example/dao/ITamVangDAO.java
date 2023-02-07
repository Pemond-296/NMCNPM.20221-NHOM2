package com.example.dao;

import com.example.model.TamVangModel;

public interface ITamVangDAO extends GenericDAO<TamVangModel> {
    Long save(TamVangModel model);
}
