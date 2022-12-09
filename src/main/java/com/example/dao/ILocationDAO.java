package com.example.dao;

import com.example.model.LocationModel;

public interface ILocationDAO extends GenericDAO<LocationModel> {
    Long save(LocationModel locationModel);
}
