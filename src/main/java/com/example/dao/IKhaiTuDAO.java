package com.example.dao;

import com.example.model.KhaiTuModel;

public interface IKhaiTuDAO extends GenericDAO<KhaiTuModel> {
    Long save(KhaiTuModel model);
}

