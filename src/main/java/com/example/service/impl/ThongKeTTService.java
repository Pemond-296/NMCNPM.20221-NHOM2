package com.example.service.impl;

import com.example.dao.IThongKeTTDAO;
import com.example.dao.impl.ThongKeTTDAO;
import com.example.model.EventGiftModel;
import com.example.model.ThongKeTTModel;
import com.example.service.IThongKeTTService;

import java.util.List;

public class ThongKeTTService implements IThongKeTTService {
    private IThongKeTTDAO iThongKeTTDAO = new ThongKeTTDAO();

    @Override
    public List<ThongKeTTModel> findByDip(EventGiftModel e) {
        return iThongKeTTDAO.findByDip(e);
    }
}