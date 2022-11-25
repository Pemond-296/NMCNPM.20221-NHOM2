package com.example.model;

import java.sql.Date;

public class IdentifierModel {
    private Long id;
    private String identityNumber;
    private Date cardReleaseDate;
    private String cardReleasePlace;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getCardReleaseDate() {
        return cardReleaseDate;
    }

    public void setCardReleaseDate(Date cardReleaseDate) {
        this.cardReleaseDate = cardReleaseDate;
    }

    public String getCardReleasePlace() {
        return cardReleasePlace;
    }

    public void setCardReleasePlace(String cardReleasePlace) {
        this.cardReleasePlace = cardReleasePlace;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
