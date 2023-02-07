package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.ThongKeTTModel;

import java.util.List;

public interface IThongKeTTDAO {
    public List<ThongKeTTModel> findByDip(EventGiftModel e);
}
