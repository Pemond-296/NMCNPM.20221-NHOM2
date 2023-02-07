package com.example.model;

public class MinhChungModel {
    private  Long id_dip;
    private String ten_nhan_khau;
    private Long id;
    private Long id_nhan_khau;
    private Integer nam;
    private Long id_thanhtich;

    public String getTen_nhan_khau() {
        return ten_nhan_khau;
    }

    public void setTen_nhan_khau(String ten_nhan_khau) {
        this.ten_nhan_khau = ten_nhan_khau;
    }

    public Long getId_dip() {
        return id_dip;
    }

    public void setId_dip(Long id_dip) {
        this.id_dip = id_dip;
    }

    public MinhChungModel(Long id_dip, Long id, Long id_nhan_khau, Integer nam, Long id_thanhtich) {
        this.id_dip = id_dip;
        this.id = id;
        this.id_nhan_khau = id_nhan_khau;
        this.nam = nam;
        this.id_thanhtich = id_thanhtich;
    }

    public MinhChungModel() {
    }

    public MinhChungModel(Long id, Long id_nhan_khau, Integer nam, Long id_thanhtich) {
        this.id = id;
        this.id_nhan_khau = id_nhan_khau;
        this.nam = nam;
        this.id_thanhtich = id_thanhtich;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_nhan_khau() {
        return id_nhan_khau;
    }

    public void setId_nhan_khau(Long id_nhan_khau) {
        this.id_nhan_khau = id_nhan_khau;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public Long getId_thanhtich() {
        return id_thanhtich;
    }

    public void setId_thanhtich(Long id_thanhtich) {
        this.id_thanhtich = id_thanhtich;
    }
}
