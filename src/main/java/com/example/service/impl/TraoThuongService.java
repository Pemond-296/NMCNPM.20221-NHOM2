package com.example.service.impl;

import com.example.dao.ITraoThuongDAO;
import com.example.dao.impl.TraoThuongDAO;
import com.example.model.GiftTableModel;
import com.example.model.MinhChungModel;
import com.example.model.TraoThuongModel;
import com.example.service.ITraoThuongService;

public class TraoThuongService implements ITraoThuongService {
    private ITraoThuongDAO iTraoThuongDAO = new TraoThuongDAO();
    @Override
    public Long save(TraoThuongModel traoThuongModel) {
        return iTraoThuongDAO.save(traoThuongModel);
    }

    @Override
    public boolean findByMinhChung(GiftTableModel minhChungModel) {
        return iTraoThuongDAO.findByMinhChung(minhChungModel);
    }
}
