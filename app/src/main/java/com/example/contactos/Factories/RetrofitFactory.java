package com.example.contactos.Factories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static Retrofit build() {

        return new Retrofit.Builder()
                .baseUrl("https://6284e91ba48bd3c40b77c5c0.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
