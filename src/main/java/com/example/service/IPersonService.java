package com.example.service;

import com.example.model.PersonModel;

import java.util.List;

public interface IPersonService {
    List<PersonModel> findAll();

    PersonModel findById(Long id);
    Long save(PersonModel personModel);

}
