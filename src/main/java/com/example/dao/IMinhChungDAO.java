package com.example.dao;

import com.example.model.MinhChungModel;

public interface IMinhChungDAO extends GenericDAO<MinhChungModel> {
    Long save(MinhChungModel minhChungModel);

}
