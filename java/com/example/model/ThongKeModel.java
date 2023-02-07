package com.example.model;

public class ThongKeModel {
    private Integer stt;
    private String ten_chu_ho;
    private String phan_qua;
    private Integer tien;
    private Integer so_luong;

    public ThongKeModel(Integer stt, String ten_chu_ho, Integer tien, Integer so_luong) {
        this.stt = stt;
        this.ten_chu_ho = ten_chu_ho;
//        this.phan_qua = phan_qua;
        this.tien = tien;
        this.so_luong = so_luong;
    }

    public ThongKeModel() {

    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getTen_chu_ho() {
        return ten_chu_ho;
    }

    public void setTen_chu_ho(String ten_chu_ho) {
        this.ten_chu_ho = ten_chu_ho;
    }

    public String getPhan_qua() {
        return phan_qua;
    }

    public void setPhan_qua(String phan_qua) {
        this.phan_qua = phan_qua;
    }

    public Integer getTien() {
        return tien;
    }

    public void setTien(Integer tien) {
        this.tien = tien;
    }

    public Integer getSo_Luong() {
        return so_luong;
    }

    public void setSo_Luong(Integer so_luong) {
        this.so_luong = so_luong;
    }
}
