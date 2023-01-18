package com.example.model;

import java.util.Date;

public class GiftTableModel {
    private Integer so_thu_tu;
    private String ten_nhan_khau;
    private String ten_thanh_tich;
    private String ten_phan_qua;
    private Integer tien_phan_qua;
    private Integer tuoi;
    private Date ngay_thang;
    private String ten_dip;
    private String ten_doi_tuong;
    private Integer so_luong;
    private Long id_dip;
    private Long id_minhchung;
    private String trang_thai;

    public Long getId_dip() {
        return id_dip;
    }

    public void setId_dip(Long id_dip) {
        this.id_dip = id_dip;
    }

    public Long getId_minhchung() {
        return id_minhchung;
    }

    public void setId_minhchung(Long id_minhchung) {
        this.id_minhchung = id_minhchung;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public GiftTableModel(){

    }
    public GiftTableModel(Integer so_thu_tu, String ten_nhan_khau, String ten_thanh_tich, String ten_phan_qua, Integer tien_phan_qua, Integer tuoi, Date ngay_thang, String ten_dip, String ten_doi_tuong, Integer so_luong) {
        this.so_thu_tu = so_thu_tu;
        this.ten_nhan_khau = ten_nhan_khau;
        this.ten_thanh_tich = ten_thanh_tich;
        this.ten_phan_qua = ten_phan_qua;
        this.tien_phan_qua = tien_phan_qua;
        this.tuoi = tuoi;
        this.ngay_thang = ngay_thang;
        this.ten_dip = ten_dip;
        this.ten_doi_tuong = ten_doi_tuong;
        this.so_luong = so_luong;
    }

    public Integer getSo_thu_tu() {
        return so_thu_tu;
    }

    public void setSo_thu_tu(Integer so_thu_tu) {
        this.so_thu_tu = so_thu_tu;
    }

    public String getTen_nhan_khau() {
        return ten_nhan_khau;
    }

    public void setTen_nhan_khau(String ten_nhan_khau) {
        this.ten_nhan_khau = ten_nhan_khau;
    }

    public String getTen_thanh_tich() {
        return ten_thanh_tich;
    }

    public void setTen_thanh_tich(String ten_thanh_tich) {
        this.ten_thanh_tich = ten_thanh_tich;
    }

    public String getTen_phan_qua() {
        return ten_phan_qua;
    }

    public void setTen_phan_qua(String ten_phan_qua) {
        this.ten_phan_qua = ten_phan_qua;
    }

    public Integer getTien_phan_qua() {
        return tien_phan_qua;
    }

    public void setTien_phan_qua(Integer tien_phan_qua) {
        this.tien_phan_qua = tien_phan_qua;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public Date getNgay_thang() {
        return ngay_thang;
    }

    public void setNgay_thang(Date ngay_thang) {
        this.ngay_thang = ngay_thang;
    }

    public String getTen_dip() {
        return ten_dip;
    }

    public void setTen_dip(String ten_dip) {
        this.ten_dip = ten_dip;
    }

    public String getTen_doi_tuong() {
        return ten_doi_tuong;
    }

    public void setTen_doi_tuong(String ten_doi_tuong) {
        this.ten_doi_tuong = ten_doi_tuong;
    }

    public Integer getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(Integer so_luong) {
        this.so_luong = so_luong;
    }
}
