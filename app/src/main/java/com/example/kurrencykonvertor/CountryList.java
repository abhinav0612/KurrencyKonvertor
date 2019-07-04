package com.example.kurrencykonvertor;

public class CountryList {
    private String countryName;
    private  String currencyCode;
    private int imageid;

    public CountryList(String countryName, int imageid, String currencyCode) {
        this.countryName = countryName;
        this.currencyCode = currencyCode;
        this.imageid = imageid;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getImageid() {
        return imageid;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
