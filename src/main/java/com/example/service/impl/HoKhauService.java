package com.example.service.impl;

import com.example.dao.IHoKhauDAO;
import com.example.dao.impl.HoKhauDAO;
import com.example.model.HoKhauModel;
import com.example.service.IHoKhauService;

import java.util.List;

public class HoKhauService implements IHoKhauService {
    private IHoKhauDAO apartmentDAO;

    public HoKhauService() {
        apartmentDAO = new HoKhauDAO();
    }
    @Override
    public List<HoKhauModel>findAll() {

        return apartmentDAO.findAll();
    }

    @Override
    public Long save(HoKhauModel hoKhauModel) {
        return apartmentDAO.save(hoKhauModel);
    }

    @Override
    public Long count() {
        return apartmentDAO.count();
    }
}
