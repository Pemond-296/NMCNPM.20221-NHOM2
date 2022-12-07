package com.example.dao;

import com.example.model.AbsentModel;

public interface IAbsentDAO extends GenericDAO<AbsentModel> {
    Long save(AbsentModel model);
}
