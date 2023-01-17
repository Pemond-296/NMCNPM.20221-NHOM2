package com.example.mapper;

import com.example.model.EventGiftModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventGiftMapper implements RowMapper<EventGiftModel>{
    @Override
    public EventGiftModel mapRow(ResultSet rs){
        EventGiftModel eventGiftModel = new EventGiftModel();
        try{
            eventGiftModel.setId(rs.getLong("idDip"));
            eventGiftModel.setDate(rs.getDate("date"));
            eventGiftModel.setNameEvent(rs.getString("TenDip"));
            eventGiftModel.setTen_doi_tuong(rs.getString("TenDoiTuong"));
            eventGiftModel.setIdQua(rs.getLong("idQua"));
            eventGiftModel.setLoai_dip(rs.getInt("LoaiDip"));

            return eventGiftModel;

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }

}
