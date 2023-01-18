package com.example.model;

import java.util.Date;

public class EventGiftModel {

    private Long id;
    private String nameEvent;
    private Integer tong_tien;
    private Date date;
    private String ten_doi_tuong;
    private Long idQua;
    private String ten_qua;
    private String trang_thai;
    private Integer loai_dip; // 0 - giua nam, 1 - cuoi nam

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public Integer getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(Integer tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getTen_qua() {
        return ten_qua;
    }

    public void setTen_qua(String ten_qua) {
        this.ten_qua = ten_qua;
    }

    public EventGiftModel(){

    }

    public Integer getLoai_dip() {
        return loai_dip;
    }

    public void setLoai_dip(Integer loai_dip) {
        this.loai_dip = loai_dip;
        if(loai_dip == 0){
            setTen_qua("Banh, keo");
        }
        else setTen_qua("Sach, vo");
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
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

    public Long getIdQua() {
        return idQua;
    }

    public void setIdQua(Long idQua) {
        this.idQua = idQua;
    }
}
