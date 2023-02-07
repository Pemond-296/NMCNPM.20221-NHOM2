package com.example.model;

import java.sql.Date;

public class HoKhauModel {
    private String id;
    private String tenChuHo;
    private Integer soNha;
    private String tenDuong;
    private String phuongXa;
    private String quanHuyen;
    private String noiDungThayDoi;
    private Date thoiGianThayDoi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public Integer getSoNha() {
        return soNha;
    }

    public void setSoNha(Integer soNha) {
        this.soNha = soNha;
    }

    public String getTenDuong() {
        return tenDuong;
    }

    public void setTenDuong(String tenDuong) {
        this.tenDuong = tenDuong;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getNoiDungThayDoi() {
        return noiDungThayDoi;
    }

    public void setNoiDungThayDoi(String noiDungThayDoi) {
        this.noiDungThayDoi = noiDungThayDoi;
    }

    public Date getThoiGianThayDoi() {
        return thoiGianThayDoi;
    }

    public void setThoiGianThayDoi(Date thoiGianThayDoi) {
        this.thoiGianThayDoi = thoiGianThayDoi;
    }
}
