package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;

import java.util.List;

public interface IMinhChungDAO extends GenericDAO<MinhChungModel> {
    Long save(MinhChungModel minhChungModel);
    List<MinhChungModel> findByDip(EventGiftModel eventGiftModel);
    Integer isMinhChung(NhanKhauModel nhanKhauModel);
    void update(MinhChungModel minhChungModel);

}
