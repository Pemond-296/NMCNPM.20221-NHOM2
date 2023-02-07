package com.example.service.impl;

import com.example.dao.IThongKeDAO;
import com.example.dao.impl.ThongKeDAO;
import com.example.model.EventGiftModel;
import com.example.model.ThongKeModel;
import com.example.service.IThongKeService;

import java.util.Enumeration;
import java.util.List;

public class ThongKeService implements IThongKeService {
    private IThongKeDAO iThongKeDAO = new ThongKeDAO();

    @Override
    public List<ThongKeModel> findByDip(EventGiftModel e) {
        return iThongKeDAO.findByDip(e);
    }
}