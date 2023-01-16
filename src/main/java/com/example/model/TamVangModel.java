package com.example.model;

import java.sql.Date;

public class TamVangModel {
    private Long id;
    private Date ngayDi;
    private Date ngayVe;
    private String ghiChu;
    private Long idNhanKhau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public Date getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(Date ngayVe) {
        this.ngayVe = ngayVe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Long getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(Long idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }
}
