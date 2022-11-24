package com.example.model;

import java.util.Date;

public class LocationModel {
    private Long id;
    private Date moveDay;
    private String movePlace;
    private String note;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMoveDay() {
        return moveDay;
    }

    public void setMoveDay(Date moveDay) {
        this.moveDay = moveDay;
    }

    public String getMovePlace() {
        return movePlace;
    }

    public void setMovePlace(String movePlace) {
        this.movePlace = movePlace;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
