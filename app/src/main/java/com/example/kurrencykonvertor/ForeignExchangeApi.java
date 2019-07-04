package com.example.kurrencykonvertor;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ForeignExchangeApi {
    @GET("latest")
    Call<ForeignExchange> getConverted(@QueryMap Map<String,String> parametres);
}
