package com.example.dao.impl;

import com.example.dao.IThongKeTTDAO;
import com.example.mapper.ThongKeTTMapper;
import com.example.model.EventGiftModel;
import com.example.model.ThongKeTTModel;

import java.util.List;

public class ThongKeTTDAO extends AbstractDAO<ThongKeTTModel> implements IThongKeTTDAO {
    @Override
    public List<ThongKeTTModel> findByDip(EventGiftModel e) {
        StringBuilder sql = new StringBuilder("select ten_chu_ho, ten_phan_thuong, so_luong, (gia_tri * so_luong) as tien");
        sql.append(" from Dip inner join qua on Dip.idQua = qua.id");
        sql.append(" inner join MinhChung mc on mc.idDip = Dip.idDip");
        sql.append(" inner join TraoThuong tt on tt.idMinhChung = mc.idMinhChung");
        sql.append(" inner join nhankhau nk on nk.id = mc.idNhanKhau");
        sql.append(" inner join hokhau hk on hk.id = nk.id_hokhau");
        sql.append(" where Dip.idDip = ?");

        return query(sql.toString(), new ThongKeTTMapper(), e.getId());
    }


}