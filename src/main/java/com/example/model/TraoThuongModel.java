package com.example.model;

public class TraoThuongModel {
    private Integer so_luong;
    private Long id_dip;
    private Long id_minhChung;
    private Long id_phanQua;
    public TraoThuongModel(){

    }
    public TraoThuongModel(Integer so_luong, Long id_dip, Long id_minhChung, Long id_phanQua) {
        this.so_luong = so_luong;
        this.id_dip = id_dip;
        this.id_minhChung = id_minhChung;
        this.id_phanQua = id_phanQua;
    }

    public Integer getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(Integer so_luong) {
        this.so_luong = so_luong;
    }

    public Long getId_dip() {
        return id_dip;
    }

    public void setId_dip(Long id_dip) {
        this.id_dip = id_dip;
    }

    public Long getId_minhChung() {
        return id_minhChung;
    }

    public void setId_minhChung(Long id_minhChung) {
        this.id_minhChung = id_minhChung;
    }

    public Long getId_phanQua() {
        return id_phanQua;
    }

    public void setId_phanQua(Long id_phanQua) {
        this.id_phanQua = id_phanQua;
    }
}
