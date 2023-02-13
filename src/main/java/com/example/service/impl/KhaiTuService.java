package com.example.service.impl;


import com.example.dao.IKhaiTuDAO;
import com.example.dao.impl.KhaiTuDAO;
import com.example.model.KhaiTuModel;
import com.example.service.IKhaiTuService;

public class KhaiTuService implements IKhaiTuService {
    private IKhaiTuDAO khaiTuDAO = new KhaiTuDAO();
    public Long save(KhaiTuModel model) {
        return khaiTuDAO.save(model);
    }

    @Override
    public KhaiTuModel findFirstByIdNhanKhau(Long id) {
        return khaiTuDAO.findFirstByIdNhanKhau(id);
    }

    @Override
    public void delete(Long idNhanKhau) {
        khaiTuDAO.delete(idNhanKhau);
    }
}