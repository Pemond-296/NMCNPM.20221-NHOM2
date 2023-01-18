package com.example.dao.impl;

import com.example.dao.IGiftEventDAO;
import com.example.mapper.EventGiftMapper;
import com.example.model.EventGiftModel;

import java.util.List;

public class EventGiftDAO extends AbstractDAO<EventGiftModel> implements IGiftEventDAO {
    @Override
    public Long save(EventGiftModel eventGiftModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO Dip ");
        sql.append("VALUES (?, ?, ?, ?, ? )");

        return insert(sql.toString(), eventGiftModel.getNameEvent(), eventGiftModel.getDate(),
                eventGiftModel.getTen_doi_tuong(), eventGiftModel.getIdQua(), eventGiftModel.getLoai_dip());
    }
    @Override
    public List<EventGiftModel> findAll(){
        String sql = "SELECT * FROM Dip";
        return query(sql, new EventGiftMapper());
    }

    @Override
    public void update(EventGiftModel eventGiftModel) {
        String sql = "UPDATE Dip SET tenDip = ?, " +
                "date = ?, " +
                "TenDoiTuong = ? , " +
                "idQua = ?" +
                "LoaiDip = ?" +
                " WHERE idDip = ?";
        update(sql, eventGiftModel.getNameEvent(), eventGiftModel.getDate(), eventGiftModel.getTen_doi_tuong(), eventGiftModel.getIdQua(),
                eventGiftModel.getLoai_dip(),
                eventGiftModel.getId());
    }

    @Override
    public void deleta(EventGiftModel eventGiftModel) {
        StringBuilder sql = new StringBuilder("DELETE MinhChung WHERE idDip = ?");
        sql.append(" DELETE Dip WHERE idDip = ?");
        update(sql.toString(), eventGiftModel.getId());
    }

}
