package com.example.service;

import com.example.model.TamTruModel;

public interface ITamTruService {
    Long save(TamTruModel model);
    TamTruModel findFirstByNhanKhauId(Long id);
    void delete(Long idNhanKhau);
    Long count();
}
