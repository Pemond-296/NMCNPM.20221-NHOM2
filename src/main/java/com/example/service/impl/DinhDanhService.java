package com.example.service.impl;

import com.example.dao.IDinhDanhDAO;
import com.example.dao.impl.DinhDanhDAO;
import com.example.model.DinhDanhModel;
import com.example.service.IDinhDanhService;

public class DinhDanhService implements IDinhDanhService {
    private IDinhDanhDAO iDinhDanhDAO = new DinhDanhDAO();
    @Override
    public Long save(DinhDanhModel dinhDanhModel) {
        return iDinhDanhDAO.save(dinhDanhModel);
    }

    @Override
    public void update(DinhDanhModel dinhDanhModel) {
        iDinhDanhDAO.update(dinhDanhModel);
    }

    @Override
    public void delete(Long idNhanKhau) {
        iDinhDanhDAO.delete(idNhanKhau);
    }
}
