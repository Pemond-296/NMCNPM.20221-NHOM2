package com.example.dao;

import com.example.model.HoKhauModel;

import java.util.List;

public interface IHoKhauDAO extends GenericDAO<HoKhauModel> {
    List<HoKhauModel> findAll();
    Long save(HoKhauModel hoKhauModel);
    Long count();
    void update(HoKhauModel hoKhauModel);
}
