package com.example.service.impl;

import com.example.dao.IApartmentDAO;
import com.example.dao.impl.ApartmentDAO;
import com.example.model.ApartmentModel;
import com.example.service.IApartmentService;

import java.util.List;

public class ApartmentService implements IApartmentService {
    private IApartmentDAO apartmentDAO;

    public ApartmentService() {
        apartmentDAO = new ApartmentDAO();
    }
    @Override
    public List<ApartmentModel> findAll() {

        return apartmentDAO.findAll();
    }
}
