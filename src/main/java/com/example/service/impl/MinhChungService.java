package com.example.service.impl;

import com.example.dao.IMinhChungDAO;
import com.example.dao.impl.MinhChungDAO;
import com.example.model.MinhChungModel;
import com.example.service.IMinhChungService;

public class MinhChungService implements IMinhChungService {
    private IMinhChungDAO iMinhChungDAO= new MinhChungDAO();
    @Override
    public Long save(MinhChungModel minhChungModel) {
        return iMinhChungDAO.save(minhChungModel);
    }
}
