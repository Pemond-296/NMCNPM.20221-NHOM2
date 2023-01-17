package com.example.dao.impl;

import com.example.dao.IMinhChungDAO;
import com.example.mapper.MinhChungMapper;
import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.PersonModel;
import com.example.utils.DipUtil;

import java.util.List;

public class MinhChungDAO extends AbstractDAO<MinhChungModel> implements IMinhChungDAO {

    @Override
    public Long save(MinhChungModel minhChungModel) {
        StringBuilder sql = new StringBuilder("INSERT MinhChung ");
        sql.append("VALUES(?, ?, ?)");

        return insert(sql.toString(), minhChungModel.getId_nhan_khau(),
                minhChungModel.getId_thanhtich(), minhChungModel.getId_dip());
    }

    @Override
    public List<MinhChungModel> findByDip(EventGiftModel eventGiftModel) {

        StringBuilder sql = new StringBuilder("SELECT * FROM MinhChung ");
        sql.append("WHERE idDip = ?");

        List<MinhChungModel> minhChungModels = query(sql.toString(), new MinhChungMapper(), eventGiftModel.getId());
        return minhChungModels.isEmpty() ? null : minhChungModels;
    }

    @Override
    public Integer isMinhChung(PersonModel personModel) {
        String sql = "SELECT * FROM MinhChung mc, nhankhau nk WHERE mc.idNhanKhau = ? AND mc.idDip = ?";
        List<MinhChungModel> minhChungModels = query(sql, new MinhChungMapper(), personModel.getId(), DipUtil.getInstance().getData().getId());
        if (minhChungModels == null || minhChungModels.isEmpty()){
            return 0;
        }
        return 1;
    }

    @Override
    public void update(MinhChungModel minhChungModel) {
        String sql = "UPDATE MinhChung SET idThanhTich = ? WHERE idDip = ? AND idNhanKhau = ?";
        update(sql, minhChungModel.getId_thanhtich(), minhChungModel.getId_dip(), minhChungModel.getId_nhan_khau());
    }
}
