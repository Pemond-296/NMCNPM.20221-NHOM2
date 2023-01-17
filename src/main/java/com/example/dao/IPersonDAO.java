package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.PersonModel;

import java.util.List;

public interface IPersonDAO {
    List<PersonModel> findAll();
    PersonModel findById(Long id);
    Long save(PersonModel personModel);
    List<PersonModel> findMonitor();
    void update(PersonModel personModel);
    public List<PersonModel> findByAge();
    List<PersonModel> findByProof(MinhChungModel minhChungModel);
    List<PersonModel> findNotProof(EventGiftModel eventGiftModel);
}
