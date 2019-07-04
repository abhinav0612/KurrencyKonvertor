package com.example.kurrencykonvertor;

public class ForeignExchange {
    private String date;
    private String base;
    private Rates rates;

    public ForeignExchange(String date, String base, Rates rates) {
        this.date = date;
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public String getBase() {
        return base;
    }

    public Rates getRates() {
        return rates;
    }
}
