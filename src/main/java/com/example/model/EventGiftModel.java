package com.example.model;

import java.util.Date;

public class EventGiftModel {

    private Long id;
    private String nameEvent;
    private Date date;
    private String ten_doi_tuong;
    private String ten_phan_thuong;
    public EventGiftModel(){

    }

    public EventGiftModel(String nameEvent, Date date, String ten_doi_tuong, String ten_phan_thuong) {
        this.nameEvent = nameEvent;
        this.date = date;
        this.ten_doi_tuong = ten_doi_tuong;
        this.ten_phan_thuong = ten_phan_thuong;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventGiftModel(Long id, String nameEvent, Date date, String ten_doi_tuong, String ten_phan_thuong) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.date = date;
        this.ten_doi_tuong = ten_doi_tuong;
        this.ten_phan_thuong = ten_phan_thuong;
    }
    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTen_doi_tuong() {
        return ten_doi_tuong;
    }

    public void setTen_doi_tuong(String ten_doi_tuong) {
        this.ten_doi_tuong = ten_doi_tuong;
    }

    public String getTen_phan_thuong() {
        return ten_phan_thuong;
    }

    public void setTen_phan_thuong(String ten_phan_thuong) {
        this.ten_phan_thuong = ten_phan_thuong;
    }

}
