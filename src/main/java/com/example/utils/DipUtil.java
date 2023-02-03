package com.example.utils;

import com.example.model.EventGiftModel;
import com.example.service.IEventGiftService;
import com.example.service.impl.EventGiftService;

import java.util.ArrayList;
import java.util.List;

public class DipUtil {
    private static DipUtil dipUtil = null;
    private IEventGiftService iEventGiftService = new EventGiftService();
    private List<EventGiftModel> eventGiftModelList = iEventGiftService.findAll();
    private EventGiftModel data = null;

    public static DipUtil getInstance() {
        if (dipUtil == null) dipUtil = new DipUtil();

        return dipUtil;
    }

    public EventGiftModel getData() {
        return data;
    }

    public void setData(EventGiftModel data) {
        this.data = data;
    }

    public void addDip(EventGiftModel eventGiftModel){
        eventGiftModelList.add(eventGiftModel);
    }
    public void xoaDip(EventGiftModel eventGiftModel) {
        for (EventGiftModel model : eventGiftModelList) {
            if (model.getId() == eventGiftModel.getId()) {
                eventGiftModelList.remove(model);
            }
        }
    }
    public void update(EventGiftModel eventGiftModel){
        for(EventGiftModel model : eventGiftModelList){
            if (model.getId() == eventGiftModel.getId()){
                model.setDate(eventGiftModel.getDate());
                model.setTen_doi_tuong(eventGiftModel.getTen_doi_tuong());
                model.setTrang_thai(eventGiftModel.getTrang_thai());
                model.setIdQua(eventGiftModel.getIdQua());
                model.setLoai_dip(eventGiftModel.getLoai_dip());
            }
        }
    }

    public List<EventGiftModel> findByName(String name){

        List<EventGiftModel> models = new ArrayList<>();

        for(EventGiftModel eventGiftModel : eventGiftModelList){
                if(eventGiftModel.getNameEvent().toLowerCase().contains(name)) {
                    models.add(eventGiftModel);
            }

        }
        return models;

    }
    public List<EventGiftModel> getEventGiftModelList(){
        return eventGiftModelList;
    }
    public List<EventGiftModel> findByStatus(boolean t, String tendip){
        List<EventGiftModel> models1 = new ArrayList<>();
        List<EventGiftModel> models2 = new ArrayList<>();

        for(EventGiftModel model : eventGiftModelList){
            if(model.getNameEvent().toLowerCase().contains(tendip)){
                if (model.getTrang_thai_bool() == 0){
                    models1.add(model);
                }
                else{
                    models2.add(model);

                }
            }
        }
        if (t == true){
            return models1;
        }
        else return models2;
    }
    public void removeData() {
        setData(null);
    }
}
