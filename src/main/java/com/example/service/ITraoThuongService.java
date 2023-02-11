package com.example.service;

import com.example.model.GiftTableModel;
import com.example.model.MinhChungModel;
import com.example.model.TraoThuongModel;

public interface ITraoThuongService {
    Long save(TraoThuongModel traoThuongModel);
    boolean findByMinhChung(GiftTableModel minhChungModel);
    void update(TraoThuongModel traoThuongModel);
}
