package com.example.mapper;
import com.example.model.MinhChungModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MinhChungMapper implements RowMapper<MinhChungModel>{
    @Override
    public MinhChungModel mapRow(ResultSet rs) {
        MinhChungModel model = new MinhChungModel();

        try {
            model.setId(rs.getLong("id"));
            model.setId_nhan_khau(rs.getLong("idNhanKhau"));
            model.setNam(rs.getInt("Nam"));
            model.setId_thanhtich(rs.getLong("idThanhTich"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
