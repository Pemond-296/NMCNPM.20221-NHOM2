package com.example.service.impl;

import com.example.dao.IGiftEventDAO;
import com.example.dao.impl.EventGiftDAO;
import com.example.model.EventGiftModel;
import com.example.service.IEventGiftService;

import java.util.List;

public class EventGiftService implements IEventGiftService {
    private IGiftEventDAO iGiftEventDAO;
    public EventGiftService(){
        iGiftEventDAO = new EventGiftDAO();
    }
    @Override
    public Long save(EventGiftModel eventGiftModel) {
        return iGiftEventDAO.save(eventGiftModel);
    }
    @Override
    public List<EventGiftModel> findAll(){
        return iGiftEventDAO.findAll();
    }
    public void update(EventGiftModel eventGiftModel){
        iGiftEventDAO.update(eventGiftModel);
    }
}
