package com.example.model;

import java.sql.Date;

public class DiaDiemModel {
    private Long id;
    private Date ngayChuyen;
    private String noiChuyen;
    private String ghiChu;
    private Long idNhanKhau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayChuyen() {
        return ngayChuyen;
    }

    public void setNgayChuyen(Date ngayChuyen) {
        this.ngayChuyen = ngayChuyen;
    }

    public String getNoiChuyen() {
        return noiChuyen;
    }

    public void setNoiChuyen(String noiChuyen) {
        this.noiChuyen = noiChuyen;
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
