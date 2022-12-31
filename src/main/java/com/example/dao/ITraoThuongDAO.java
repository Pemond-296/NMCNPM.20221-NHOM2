package com.example.dao;

import com.example.model.TraoThuongModel;

public interface ITraoThuongDAO extends GenericDAO<TraoThuongModel> {
    Long save(TraoThuongModel traoThuongModel);
}
