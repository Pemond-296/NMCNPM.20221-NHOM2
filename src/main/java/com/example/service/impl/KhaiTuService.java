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
}