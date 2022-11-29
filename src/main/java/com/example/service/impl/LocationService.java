package com.example.service.impl;

import com.example.dao.ILocationDAO;
import com.example.dao.impl.LocationDAO;
import com.example.model.LocationModel;
import com.example.service.ILocationService;

public class LocationService implements ILocationService {
    private ILocationDAO locationDAO = new LocationDAO();
    @Override
    public Long save(LocationModel locationModel) {
        return locationDAO.save(locationModel);
    }
}
