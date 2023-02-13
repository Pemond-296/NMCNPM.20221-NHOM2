package com.example.dao;

import com.example.model.TamVangModel;

public interface ITamVangDAO extends GenericDAO<TamVangModel> {
    Long save(TamVangModel model);
    TamVangModel findFirstByNhanKhauId(Long id);
    void delete(Long idNhanKhau);
    Long count();
}
