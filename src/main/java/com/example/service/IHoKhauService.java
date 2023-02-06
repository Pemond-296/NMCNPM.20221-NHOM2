package com.example.service;

import com.example.model.HoKhauModel;

import java.util.List;

public interface IHoKhauService {
    List<HoKhauModel> findAll();
    Long save(HoKhauModel hoKhauModel);
    Long count();


}
