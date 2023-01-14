package com.example.utils;

import com.example.model.ApartmentModel;
import com.example.service.IApartmentService;
import com.example.service.impl.ApartmentService;

import java.util.List;

public class ApartmentUtil {
    private static ApartmentUtil apartmentUtil = null;
    private IApartmentService apartmentService = new ApartmentService();
    private List<ApartmentModel> models = apartmentService.findAll();

    public static ApartmentUtil getInstance() {
        if (apartmentUtil == null) apartmentUtil = new ApartmentUtil();

        return apartmentUtil;
    }

    public ApartmentUtil getApartmentUtil() {
        return apartmentUtil;
    }

    public void setApartmentUtil(ApartmentUtil apartmentUtil) {
        ApartmentUtil.apartmentUtil = apartmentUtil;
    }

    public List<ApartmentModel> getModels() {
        return models;
    }

    public void setModels(List<ApartmentModel> models) {
        this.models = models;
    }

    public void add(ApartmentModel model) {
        models.add(model);
    }

    public void addAll() {
        models.addAll(apartmentService.findAll());
    }
}
