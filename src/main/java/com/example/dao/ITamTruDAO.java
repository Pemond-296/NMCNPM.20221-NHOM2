package com.example.dao;

import com.example.model.TamTruModel;

public interface ITamTruDAO extends GenericDAO<TamTruModel> {
    Long save(TamTruModel model);

}
