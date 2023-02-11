package com.example.service;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;

import java.util.List;

public interface IMinhChungService {
    Long save(MinhChungModel minhChungModel);
    List<MinhChungModel> findByDip(EventGiftModel eventGiftModel);
    Integer isMinhChung(NhanKhauModel nhanKhauModel);
    void update(MinhChungModel minhChungModel);
    boolean check(EventGiftModel eventGiftModel);
}
