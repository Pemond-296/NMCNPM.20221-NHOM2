package com.example.service;

import com.example.model.NhanKhauModel;

import java.util.List;

public interface INhanKhauService {
    List<NhanKhauModel> findAll();
    NhanKhauModel findById(Long id);
    Long save(NhanKhauModel nhanKhauModel);
    List<NhanKhauModel> findMonitor();
    List<NhanKhauModel> findAllByApartmentId(String id);
    void update(NhanKhauModel nhanKhauModel);

}
