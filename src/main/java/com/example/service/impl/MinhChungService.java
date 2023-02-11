package com.example.service.impl;

import com.example.dao.IMinhChungDAO;
import com.example.dao.impl.MinhChungDAO;
import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.NhanKhauModel;
import com.example.service.IMinhChungService;

import java.util.List;

public class MinhChungService implements IMinhChungService {
    private IMinhChungDAO iMinhChungDAO= new MinhChungDAO();
    @Override
    public Long save(MinhChungModel minhChungModel) {
        return iMinhChungDAO.save(minhChungModel);
    }

    @Override
    public List<MinhChungModel> findByDip(EventGiftModel eventGiftModel) {
        return iMinhChungDAO.findByDip(eventGiftModel);
    }

    @Override
    public Integer isMinhChung(NhanKhauModel nhanKhauModel) {
        return iMinhChungDAO.isMinhChung(nhanKhauModel);
    }

    @Override
    public void update(MinhChungModel minhChungModel) {
        iMinhChungDAO.update(minhChungModel);
    }
    @Override
    public boolean check(EventGiftModel eventGiftModel){
        return iMinhChungDAO.check(eventGiftModel);
    }
}
