package com.example.service.impl;

import com.example.dao.IPersonDAO;
import com.example.dao.impl.PersonDAO;
import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
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
    public List<PersonModel> findByAge(){
        return personDAO.findByAge();
    }

    @Override
    public List<PersonModel> findByProof(MinhChungModel minhChungModel) {
        return personDAO.findByProof(minhChungModel);
    }

    @Override
    public List<PersonModel> findNotProof(EventGiftModel eventGiftModel) {
        return personDAO.findNotProof(eventGiftModel);
    }
}
