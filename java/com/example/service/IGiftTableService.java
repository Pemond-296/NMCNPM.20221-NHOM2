package com.example.service;

import com.example.model.EventGiftModel;
import com.example.model.GiftTableModel;

import java.util.List;

public interface IGiftTableService {
    public List<GiftTableModel> findAll();

    public GiftTableModel findByIdNhanKhau(Long id);
    public List<GiftTableModel> findByDip(EventGiftModel eventGiftModel);
}
