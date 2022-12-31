package com.example.service;

import com.example.dao.impl.MinhChungDAO;
import com.example.model.MinhChungModel;

public interface IMinhChungService {
    Long save(MinhChungModel minhChungModel);
}
