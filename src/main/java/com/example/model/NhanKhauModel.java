package com.example.model;

import java.sql.Date;

public class NhanKhauModel {
    private Long id;
    private String hoTen;
    private String biDanh;
    private String gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String congViec;
    private String noiLamViec;
    private Date ngayDkiThuongTru;
    private String noiDkiThuongTru;
    private String noiOTruoc;
    private String quanHe;
    private String idHoKhau;
    private Long idCMND;
    private Long idDiaDiem;
    private DinhDanhModel dinhDanhModel;
    private DiaDiemModel diaDiemModel;
    private String soCMT;
    private String minhChung;

    public NhanKhauModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public Date getNgayDkiThuongTru() {
        return ngayDkiThuongTru;
    }

    public void setNgayDkiThuongTru(Date ngayDkiThuongTru) {
        this.ngayDkiThuongTru = ngayDkiThuongTru;
    }

    public String getNoiDkiThuongTru() {
        return noiDkiThuongTru;
    }

    public void setNoiDkiThuongTru(String noiDkiThuongTru) {
        this.noiDkiThuongTru = noiDkiThuongTru;
    }

    public String getNoiOTruoc() {
        return noiOTruoc;
    }

    public void setNoiOTruoc(String noiOTruoc) {
        this.noiOTruoc = noiOTruoc;
    }

    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    public DinhDanhModel getIdentifierModel() {
        return dinhDanhModel;
    }

    public Long getIdCMND() {
        return idCMND;
    }

    public void setIdCMND(Long idCMND) {
        this.idCMND = idCMND;
    }

    public Long getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(Long idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public void setIdentifierModel(DinhDanhModel dinhDanhModel) {
        this.dinhDanhModel = dinhDanhModel;
    }

    public DiaDiemModel getLocationModel() {
        return diaDiemModel;
    }

    public void setLocationModel(DiaDiemModel diaDiemModel) {
        this.diaDiemModel = diaDiemModel;
    }

    public String getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(String idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getMinhChung() {
        return minhChung;
    }

    public void setMinhChung(String minhChung) {
        this.minhChung = minhChung;
    }
}
