package com.example.dao.impl;

import com.example.dao.IThongKeDAO;
import com.example.mapper.ThongKeMapper;
import com.example.model.EventGiftModel;
import com.example.model.ThongKeModel;

import java.util.List;

public class ThongKeDAO extends AbstractDAO<ThongKeModel> implements IThongKeDAO {
    @Override
    public List<ThongKeModel> findByDip(EventGiftModel e) {
        StringBuilder sql = new StringBuilder("select ten_chu_ho, ten_phan_thuong, so_luong, (gia_tri * so_luong) as tien" +
                " from dip inner join qua on dip.idQua = qua.id"+
                " inner join MinhChung mc on mc.idDip = dip.idDip"+
               " inner join TraoThuong tt on tt.idMinhChung = mc.idMinhChung"+
              "  inner join nhankhau nk on nk.id = mc.idNhanKhau"+
               " inner join hokhau hk on hk.id = nk.id_hokhau"+
              "  where dip.idDip = ?");

        return query(sql.toString(), new ThongKeMapper(), e.getId());
    }


}
