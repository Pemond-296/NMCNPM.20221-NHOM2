package com.example.service.impl;

import com.example.dao.IPersonDAO;
import com.example.dao.impl.PersonDAO;
import com.example.model.PersonModel;
import com.example.service.IPersonService;

public class PersonService implements IPersonService {
    private IPersonDAO personDAO = new PersonDAO();

    @Override
    public Long save(PersonModel personModel) {
        return personDAO.save(personModel);
    }
}
