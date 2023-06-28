package com.example.CoffeeShop.service;

import com.example.CoffeeShop.model.dto.retrofit.comunication.BaristaOrderResponseDto;
import com.example.CoffeeShop.model.dto.retrofit.comunication.OrderForBaristaDto;
import com.example.CoffeeShop.model.entity.Order;
import com.example.CoffeeShop.util.RetrofitCalls;
import com.example.CoffeeShop.util.RetrofitUtil;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class CommunicatorImpl implements Communicator{

    @Override
    public BaristaOrderResponseDto giveOrderToBarista(Order order) throws IOException {
        Retrofit retrofitSender = RetrofitUtil.getRetrofit();
        RetrofitCalls baristaSender = retrofitSender.create(RetrofitCalls.class);
        Call<String> process = baristaSender.orderAtBar(new OrderForBaristaDto(order));
        Response<String> executable =process.execute();
        Gson g =new Gson();
        BaristaOrderResponseDto responseDto = g.fromJson(executable.body(), BaristaOrderResponseDto.class);
        return switch (executable.code()) {
            case 200 -> responseDto;
            case 400 -> throw new RuntimeException("Something happened try again!");
            default -> throw new IllegalStateException("Non existing order!");
        };
    }
}
