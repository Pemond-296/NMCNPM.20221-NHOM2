package com.example.service.impl;

import com.example.dao.ITamTruDAO;
import com.example.dao.impl.TamTruDAO;
import com.example.model.TamTruModel;
import com.example.service.ITamTruService;

public class TamTruService implements ITamTruService {
    private ITamTruDAO tamTruDAO = new TamTruDAO();
    @Override
    public Long save(TamTruModel model) {
        return tamTruDAO.save(model);
    }

    @Override
    public TamTruModel findFirstByNhanKhauId(Long id) {
        return tamTruDAO.findFirstByNhanKhauId(id);
    }

    @Override
    public void delete(Long idNhanKhau) {
        tamTruDAO.delete(idNhanKhau);
    }

    @Override
    public Long count() {
        return tamTruDAO.count();
    }

}
