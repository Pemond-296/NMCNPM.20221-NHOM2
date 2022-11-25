package com.example.dao.impl;

import com.example.dao.IPersonDAO;
import com.example.model.PersonModel;

import java.util.Date;

public class PersonDAO extends AbstractDAO<PersonModel> implements IPersonDAO {

    @Override
    public Long save(PersonModel personModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO nhankhau ([ho_ten], [dan_toc], [ngay_sinh], ");
        sql.append("nguyen_quan, gioi_tinh, nghe_nghiep, noi_lam_viec) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        System.out.println(personModel.getBirthDate() instanceof Date);

        return insert(sql.toString(), personModel.getName(), personModel.getEthnic(), personModel.getBirthDate(),
                personModel.getHometown(), personModel.getGender(), personModel.getJob(), personModel.getWorkPlace());
    }
}
