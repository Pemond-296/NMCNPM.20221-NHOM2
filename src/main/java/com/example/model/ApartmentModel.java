package com.example.model;

import java.sql.Date;

public class ApartmentModel {
    private Long id;
    private String name;
    private Integer apartmentNumber;
    private String roadName;
    private String wardsName;
    private String districtName;
    private String contentChanges;
    private Date dateChanges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getWardsName() {
        return wardsName;
    }

    public void setWardsName(String wardsName) {
        this.wardsName = wardsName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getContentChanges() {
        return contentChanges;
    }

    public void setContentChanges(String contentChanges) {
        this.contentChanges = contentChanges;
    }

    public Date getDateChanges() {
        return dateChanges;
    }

    public void setDateChanges(Date dateChanges) {
        this.dateChanges = dateChanges;
    }
}
