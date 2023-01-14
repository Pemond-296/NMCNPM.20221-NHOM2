package com.example.mapper;
import com.example.model.MinhChungModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MinhChungMapper implements RowMapper<MinhChungModel>{
    @Override
    public MinhChungModel mapRow(ResultSet rs) {
        MinhChungModel model = new MinhChungModel();

        try {
            model.setId(rs.getLong("idMinhChung"));
            model.setId_nhan_khau(rs.getLong("idNhanKhau"));
            model.setId_thanhtich(rs.getLong("idThanhTich"));
            model.setId_dip(rs.getLong("idDip"));
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
