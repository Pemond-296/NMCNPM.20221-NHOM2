package com.example.dao;

import com.example.model.DiaDiemModel;

public interface IDiaDiemDAO extends GenericDAO<DiaDiemModel> {
    Long save(DiaDiemModel diaDiemModel);
}
