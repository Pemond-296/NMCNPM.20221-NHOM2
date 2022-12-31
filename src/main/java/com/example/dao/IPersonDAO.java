package com.example.dao;

import com.example.model.PersonModel;

import java.sql.Date;
import java.util.List;

public interface IPersonDAO {
    List<PersonModel> findAll();
    PersonModel findById(Long id);
    Long save(PersonModel personModel);
    List<PersonModel> findMonitor();
    void update(PersonModel personModel);
    public List<PersonModel> findByAge();
}
