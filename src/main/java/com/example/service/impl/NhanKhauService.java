package com.example.service.impl;

import com.example.dao.INhanKhauDAO;
import com.example.dao.impl.NhanKhauDAO;
import com.example.model.NhanKhauModel;
import com.example.service.INhanKhauService;

import java.util.List;

public class NhanKhauService implements INhanKhauService {
    private INhanKhauDAO personDAO = new NhanKhauDAO();

    @Override
    public List<NhanKhauModel> findAll() {
        return personDAO.findAll();
    }

    @Override
    public NhanKhauModel findById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public Long save(NhanKhauModel nhanKhauModel) {
        return personDAO.save(nhanKhauModel);
    }

    @Override
    public List<NhanKhauModel> findMonitor() {
        return personDAO.findMonitor();
    }

    @Override
    public List<NhanKhauModel> findAllByApartmentId(String id) {
        return personDAO.findAllByApartmentId(id);
    }

    @Override
    public void update(NhanKhauModel nhanKhauModel) {
        personDAO.update(nhanKhauModel);
    }
}