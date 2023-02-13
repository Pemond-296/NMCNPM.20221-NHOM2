package com.example.service;

import com.example.model.TamVangModel;

public interface ITamVangService {
    Long save(TamVangModel model);
    TamVangModel findFirstByNhanKhauId(Long id);
    void delete(Long idNhanKhau);
    Long count();
}
