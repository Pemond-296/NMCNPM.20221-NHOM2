package com.example.service.impl;

import com.example.dao.IGiftTableDAO;
import com.example.dao.impl.GiftTableDAO;
import com.example.model.EventGiftModel;
import com.example.model.GiftTableModel;
import com.example.service.IGiftTableService;

import java.util.List;

public class GiftTableService implements IGiftTableService {
    private IGiftTableDAO model = new GiftTableDAO();
    @Override
    public List<GiftTableModel> findAll() {
        return model.findAll();
    }

    @Override
    public GiftTableModel findByIdNhanKhau(Long id) {
        return model.findByIdNhanKhau(id);
    }

    @Override
    public List<GiftTableModel> findByDip(EventGiftModel eventGiftModel) {
        return model.findByDip(eventGiftModel);
    }
}
