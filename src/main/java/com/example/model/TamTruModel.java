package com.example.model;

import java.sql.Date;

public class TamTruModel {
    private Long id;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;
    private Long idNhanKhau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Long getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(Long idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }
}
