package com.example.model;

import java.sql.Date;

public class KhaiTuModel {
    private Long id;
    private String nguoiKhaiTu;
    private Date ngayKhaiTu;
    private Date ngayQuaDoi;
    private String nguyenNhan;
    private Long idNhanKhau;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNguoiKhaiTu() {
        return nguoiKhaiTu;
    }

    public void setNguoiKhaiTu(String nguoiKhaiTu) {
        this.nguoiKhaiTu = nguoiKhaiTu;
    }

    public Date getNgayKhaiTu() {
        return ngayKhaiTu;
    }

    public void setNgayKhaiTu(Date ngayKhaiTu) {
        this.ngayKhaiTu = ngayKhaiTu;
    }

    public Date getNgayQuaDoi() {
        return ngayQuaDoi;
    }

    public void setNgayQuaDoi(Date ngayQuaDoi) {
        this.ngayQuaDoi = ngayQuaDoi;
    }

    public String getNguyenNhan() {
        return nguyenNhan;
    }

    public void setNguyenNhan(String nguyenNhan) {
        this.nguyenNhan = nguyenNhan;
    }

    public Long getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(Long idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }
}
