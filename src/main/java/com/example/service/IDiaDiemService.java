package com.example.service;

import com.example.model.DiaDiemModel;

public interface IDiaDiemService {
    Long save(DiaDiemModel diaDiemModel);
    DiaDiemModel findFirstByIdNhanKhau(Long id);
    void delete(Long idNhanKhau);
}
