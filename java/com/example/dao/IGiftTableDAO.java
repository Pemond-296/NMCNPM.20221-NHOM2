package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.GiftTableModel;

import java.util.List;

public interface IGiftTableDAO extends GenericDAO<GiftTableModel>{

    public List<GiftTableModel> findAll();
    public GiftTableModel findByIdNhanKhau(Long id);
    public List<GiftTableModel> findByDip(EventGiftModel eventGiftModel);
}
