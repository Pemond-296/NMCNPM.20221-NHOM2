package com.example.dao;

import com.example.model.EventGiftModel;
import com.example.model.MinhChungModel;
import com.example.model.PersonModel;

import java.util.List;

public interface IMinhChungDAO extends GenericDAO<MinhChungModel> {
    Long save(MinhChungModel minhChungModel);
    List<MinhChungModel> findByDip(EventGiftModel eventGiftModel);
    Integer isMinhChung(PersonModel personModel);
    void update(MinhChungModel minhChungModel);

}
