package com.example.utils;

import com.example.model.HoKhauModel;
import com.example.service.IHoKhauService;
import com.example.service.impl.HoKhauService;

import java.util.List;

public class ApartmentUtil {
    private static ApartmentUtil apartmentUtil = null;
    private IHoKhauService apartmentService = new HoKhauService();
    private HoKhauModel hoKhauModel = null;
    private HoKhauModel newHoKhauModel = null;
    private List<HoKhauModel> models = apartmentService.findAll();

    public static ApartmentUtil getInstance() {
        if (apartmentUtil == null) apartmentUtil = new ApartmentUtil();

        return apartmentUtil;
    }

    public HoKhauModel getApartmentModel() {
        return hoKhauModel;
    }

    public void setApartmentModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public List<HoKhauModel> getModels() {
        return models;
    }

    public void setModels(List<HoKhauModel> models) {
        this.models = models;
    }

    public void add(HoKhauModel model) {
        models.add(model);
    }

    public void addAll() {
        models.addAll(apartmentService.findAll());
    }

    public HoKhauModel getNewApartmentModel() {
        return newHoKhauModel;
    }

    public void setNewApartmentModel(HoKhauModel newHoKhauModel) {
        this.newHoKhauModel = newHoKhauModel;
    }
}
