package com.example.service.impl;

import com.example.dao.IIdentifierDAO;
import com.example.dao.impl.IdentifierDAO;
import com.example.model.IdentifierModel;
import com.example.service.IIdentifierService;

public class IdentifierService implements IIdentifierService {
    private IIdentifierDAO iIdentifierDAO = new IdentifierDAO();
    @Override
    public Long save(IdentifierModel identifierModel) {
        return iIdentifierDAO.save(identifierModel);
    }
}
