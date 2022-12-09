package com.example.service;

import com.example.model.ApartmentModel;

import java.util.List;

public interface IApartmentService {
    List<ApartmentModel> findAll();
    Long save(ApartmentModel apartmentModel);


}
