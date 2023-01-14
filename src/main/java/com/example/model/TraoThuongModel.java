package com.example.model;

public class TraoThuongModel {
    private Integer so_luong;
    private Long id_minhChung;
    private Long id_phanQua;
    private Integer trang_thai;

    public Integer getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Integer trang_thai) {
        this.trang_thai = trang_thai;
    }

    public TraoThuongModel(){

    }

    public Integer getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(Integer so_luong) {
        this.so_luong = so_luong;
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
