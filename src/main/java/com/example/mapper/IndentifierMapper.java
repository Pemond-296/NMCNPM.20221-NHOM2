package com.example.mapper;

import com.example.model.IdentifierModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndentifierMapper implements RowMapper<IdentifierModel> {
    @Override
    public IdentifierModel mapRow(ResultSet rs) {
        IdentifierModel model = new IdentifierModel();

        try {
            model.setId(rs.getLong("id"));
            model.setIdentityNumber(rs.getString("so_CMND"));
            model.setCardReleaseDate(rs.getDate("ngay_cap"));
            model.setCardReleasePlace(rs.getString("noi_cap"));
            model.setPersonId(rs.getLong("id_nhankhau"));

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
