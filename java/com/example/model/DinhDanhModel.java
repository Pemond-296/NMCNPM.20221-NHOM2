package com.example.model;

import java.sql.Date;

public class DinhDanhModel {
    private Long id;
    private String soCMT;
    private Date ngayCap;
    private String noiCap;
    private Long idNhanKhau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public Long getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(Long idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }
}
