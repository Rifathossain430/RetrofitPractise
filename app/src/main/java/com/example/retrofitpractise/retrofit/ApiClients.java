package com.example.retrofitpractise.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClients {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    public static ApiClients mInstance;

    public ApiClients() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiClients getInstance() {
        if (mInstance == null) {
            mInstance = new ApiClients();

        }
        return mInstance;

    }

    public RetrofitInterface getApi() {
        return retrofit.create(RetrofitInterface.class);
    }

}
