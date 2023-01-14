package com.example.utils;

import com.example.model.PersonModel;
import com.example.service.IPersonService;
import com.example.service.impl.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
    private static PersonUtil personUtil = null;
    private IPersonService personService = new PersonService();
    private List<PersonModel> models = personService.findAll();
    private PersonModel monitor = null;
    private PersonModel member = null;
    private PersonModel minhchung = null;
    private List<PersonModel> tempModel = new ArrayList<>();

    public static PersonUtil getInstance() {
        if (personUtil == null) personUtil = new PersonUtil();

        return personUtil;
    }

    public void removeData() {
        personUtil = null;
    }
    public List<PersonModel> getModels() {
        return models;
    }

    public void add(PersonModel model) {
        models.add(model);
    }

    public PersonModel getMonitor() {
        return monitor;
    }

    public void setMonitor(PersonModel monitor) {
        this.monitor = monitor;
    }

    public PersonModel getMember() {
        return member;
    }
    public void setMember(PersonModel member) {
        this.member = member;
    }

    public List<PersonModel> getTempModel() {
        return tempModel;
    }

    public void setTempModel(List<PersonModel> tempModel) {
        this.tempModel = tempModel;
    }

    public PersonModel getMinhchung() {
        return minhchung;
    }

    public void setMinhChung(PersonModel personModel){
        minhchung = personModel;

    }
}
