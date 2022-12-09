package com.example.service.impl;

import com.example.dao.IIdentifierDAO;
import com.example.dao.ILocationDAO;
import com.example.dao.IPersonDAO;
import com.example.dao.impl.IdentifierDAO;
import com.example.dao.impl.LocationDAO;
import com.example.dao.impl.PersonDAO;
import com.example.model.PersonModel;
import com.example.service.IPersonService;

import java.util.List;

public class PersonService implements IPersonService {
    private IPersonDAO personDAO = new PersonDAO();

    @Override
    public List<PersonModel> findAll() {
        return personDAO.findAll();
    }

    @Override
    public PersonModel findById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public Long save(PersonModel personModel) {
        return personDAO.save(personModel);
    }

    @Override
    public List<PersonModel> findMonitor() {
        return personDAO.findMonitor();
    }

    @Override
    public void update(PersonModel personModel) {
        personDAO.update(personModel);
    }
}
