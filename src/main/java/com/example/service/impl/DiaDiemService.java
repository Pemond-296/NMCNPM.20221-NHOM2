package com.example.service.impl;

import com.example.dao.IDiaDiemDAO;
import com.example.dao.impl.DiaDiemDAO;
import com.example.model.DiaDiemModel;
import com.example.service.IDiaDiemService;

public class DiaDiemService implements IDiaDiemService {
    private IDiaDiemDAO locationDAO = new DiaDiemDAO();
    @Override
    public Long save(DiaDiemModel diaDiemModel) {
        return locationDAO.save(diaDiemModel);
    }
}
