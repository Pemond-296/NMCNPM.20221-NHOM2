package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.ThongKeModel;

import java.util.List;

public interface IThongKeDAO {
    public List<ThongKeModel> findByDip(EventGiftModel e);
}
