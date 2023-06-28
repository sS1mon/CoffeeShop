package com.example.CoffeeShop.util;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        // Url/port would be different because this port is used by this microservice
        String url = "http://localhost:8080/";
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
