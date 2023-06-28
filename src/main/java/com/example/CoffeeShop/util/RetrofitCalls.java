package com.example.CoffeeShop.util;

import com.example.CoffeeShop.model.dto.retrofit.comunication.OrderForBaristaDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitCalls {
    //example of basic call
    @POST("/order")
    Call<String> orderAtBar(@Body OrderForBaristaDto orderForBaristaDto);
}
