package com.example.dao;

import com.example.model.ApartmentModel;

import java.util.List;

public interface IApartmentDAO extends GenericDAO<ApartmentModel> {
    List<ApartmentModel> findAll();
    Long save(ApartmentModel apartmentModel);
}
