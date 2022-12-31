package com.example.dao.impl;

import com.example.dao.IMinhChungDAO;
import com.example.model.ApartmentModel;
import com.example.model.MinhChungModel;

public class MinhChungDAO extends AbstractDAO<MinhChungModel> implements IMinhChungDAO {

    @Override
    public Long save(MinhChungModel minhChungModel) {
        MinhChungModel.idMinhChung++;
        StringBuilder sql = new StringBuilder("INSERT INTO MinhChung ");
        sql.append("VALUES (?, ?, ?, ?)");

        return insert(sql.toString(),minhChungModel.getId(), minhChungModel.getId_nhan_khau(), minhChungModel.getNam(),
                minhChungModel.getId_thanhtich());
    }
}
