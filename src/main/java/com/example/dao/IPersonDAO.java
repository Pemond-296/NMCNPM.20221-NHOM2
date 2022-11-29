package com.example.dao;

import com.example.model.PersonModel;

import java.util.List;

public interface IPersonDAO {
    List<PersonModel> findAll();

    PersonModel findById(Long id);
    Long save(PersonModel personModel);
}
