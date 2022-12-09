package com.example.model;

import java.sql.Date;

public class AbsentModel {
    private Long id;
    private Date dateMove;
    private Date dateBack;
    private String note;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateMove() {
        return dateMove;
    }

    public void setDateMove(Date dateMove) {
        this.dateMove = dateMove;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
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
