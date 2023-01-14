package com.example.mapper;

import com.example.model.PersonModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonModel> {
    @Override
    public PersonModel mapRow(ResultSet rs){
        PersonModel model = new PersonModel();

        try {
            model.setId(rs.getLong("id"));
            model.setName(rs.getString("ho_ten"));
            model.setNickname(rs.getString("bi_danh"));
            model.setGender(rs.getString("gioi_tinh"));
            model.setBirthDate(rs.getDate("ngay_sinh"));
            model.setBirthPlace(rs.getString("noi_sinh"));
            model.setHometown(rs.getString("nguyen_quan"));
            model.setEthnic(rs.getString("dan_toc"));
            model.setJob(rs.getString("nghe_nghiep"));
            model.setWorkPlace(rs.getString("noi_lam_viec"));
            model.setRegisterDate(rs.getDate("ngay_dk_thuong_tru"));
            model.setRegisterPlace(rs.getString("dia_chi_thuong_tru"));
            model.setPrevPlace(rs.getString("dia_chi_truoc"));
            model.setRelationship(rs.getString("chu_ho"));

//            IdentifierModel identifierModel = new IndentifierMapper().mapRow(rs);
//            LocationModel locationModel = new LocationMapper().mapRow(rs);
//
//            model.setIdentifierModel(identifierModel);
//            model.setLocationModel(locationModel);
//            model.setIdentifyId(identifierModel.getIdentityNumber());

            return model;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
