package com.example.utils;

import com.example.model.NhanKhauModel;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
    private static PersonUtil personUtil = null;
    private NhanKhauModel monitor = null;
    private NhanKhauModel member = null;
    private List<NhanKhauModel> tempModel = new ArrayList<>();

    public static PersonUtil getInstance() {
        if (personUtil == null) personUtil = new PersonUtil();

        return personUtil;
    }

    public void removeData() {
        personUtil = null;
    }
    public NhanKhauModel getMonitor() {
        return monitor;
    }

    public void setMonitor(NhanKhauModel monitor) {
        this.monitor = monitor;
    }

    public NhanKhauModel getMember() {
        return member;
    }
    public void setMember(NhanKhauModel member) {
        this.member = member;
    }

    public List<NhanKhauModel> getTempModel() {
        return tempModel;
    }

    public void setTempModel(List<NhanKhauModel> tempModel) {
        this.tempModel = tempModel;
    }
}
