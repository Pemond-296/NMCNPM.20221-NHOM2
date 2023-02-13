package com.example.dao;

import com.example.model.DinhDanhModel;

public interface IDinhDanhDAO extends GenericDAO<DinhDanhModel> {
    Long save(DinhDanhModel dinhDanhModel);
    void update(DinhDanhModel dinhDanhModel);
    void delete(Long idNhanKhau);
}
