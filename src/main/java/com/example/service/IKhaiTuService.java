package com.example.service;

import com.example.model.KhaiTuModel;

public interface IKhaiTuService {
    Long save(KhaiTuModel model);
    KhaiTuModel findFirstByIdNhanKhau(Long id);
    void delete(Long idNhanKhau);
}