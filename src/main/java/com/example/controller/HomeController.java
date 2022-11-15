package com.example.controller;

import com.example.model.ApartmentModel;
import com.example.service.IApartmentService;
import com.example.service.impl.ApartmentService;

import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private IApartmentService apartmentService;

    public HomeController() {
        apartmentService = new ApartmentService();
    }

    public void printList() {
        List<ApartmentModel> models = apartmentService.findAll();

        for(ApartmentModel model : models) {
            System.out.println(model.getName());
        }
    }
}
