package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;

import java.util.List;

public interface INhanKhauDAO {
    List<NhanKhauModel> findAll();
    NhanKhauModel findById(Long id);
    Long save(NhanKhauModel nhanKhauModel);
    List<NhanKhauModel> findMonitor();
    List<NhanKhauModel> findAllByApartmentId(String id);
    void update(NhanKhauModel nhanKhauModel);
    public List<NhanKhauModel> findByAge();
    List<NhanKhauModel> findByProof(MinhChungModel minhChungModel);
    List<NhanKhauModel> findNotProof(EventGiftModel eventGiftModel);
}
