package com.example.service.impl;

import com.example.dao.ITamVangDAO;
import com.example.dao.impl.TamVangDAO;
import com.example.model.TamVangModel;
import com.example.service.ITamVangService;

public class TamVangService implements ITamVangService {
    private ITamVangDAO absentDAO = new TamVangDAO();
    @Override
    public Long save(TamVangModel model) {
        return absentDAO.save(model);
    }

    @Override
    public TamVangModel findFirstByNhanKhauId(Long id) {
        return absentDAO.findFirstByNhanKhauId(id);
    }

    @Override
    public void delete(Long idNhanKhau) {
        absentDAO.delete(idNhanKhau);
    }

    @Override
    public Long count() {
        return absentDAO.count();
    }
}
