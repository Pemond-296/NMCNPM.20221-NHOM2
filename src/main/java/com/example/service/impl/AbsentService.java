package com.example.service.impl;

import com.example.dao.IAbsentDAO;
import com.example.dao.impl.AbsentDAO;
import com.example.model.AbsentModel;
import com.example.service.IAbsentService;

public class AbsentService implements IAbsentService {
    private IAbsentDAO absentDAO = new AbsentDAO();
    @Override
    public Long save(AbsentModel model) {
        return absentDAO.save(model);
    }
}
