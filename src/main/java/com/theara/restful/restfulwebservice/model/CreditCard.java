package com.theara.restful.restfulwebservice.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.Date;

@JsonFilter("creditCard")
public class CreditCard {

    private String cardHolder;
    private String cardNumber;
    private Date expireDate;
    private String Cvv;

    public CreditCard(String cardHolder, String cardNumber, Date expireDate, String cvv) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        Cvv = cvv;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getCvv() {
        return Cvv;
    }
}
