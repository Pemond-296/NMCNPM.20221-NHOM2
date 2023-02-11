package com.example.dao;

import com.example.model.GiftTableModel;
import com.example.model.MinhChungModel;
import com.example.model.TraoThuongModel;

public interface ITraoThuongDAO extends GenericDAO<TraoThuongModel> {
    Long save(TraoThuongModel traoThuongModel);
    boolean findByMinhChung(GiftTableModel minhChungModel);
    void update(TraoThuongModel traoThuongModel);
}
