package com.example.dao;

import com.example.model.EventGiftModel;

import java.util.List;

public interface IGiftEventDAO extends GenericDAO<EventGiftModel> {
    Long save(EventGiftModel eventGiftModel);

    public List<EventGiftModel> findAll();
    public void update(EventGiftModel eventGiftModel);
    public void deleta(EventGiftModel eventGiftModel);
}
