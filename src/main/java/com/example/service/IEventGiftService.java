package com.example.service;

import com.example.model.EventGiftModel;

import java.util.List;

public interface IEventGiftService {
    public Long save(EventGiftModel eventGiftModel);
    public List<EventGiftModel> findAll();
    public void update(EventGiftModel eventGiftModel);
}
