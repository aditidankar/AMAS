package com.example.android.amas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    public  static final String BaseURL="https://extortive-males.000webhostapp.com/_php/";
    // public  static final String BaseURL="http://10.0.2.2/Website/_php/";
    public static Retrofit retrofit;

    public static Retrofit getRetroApiClient()
    {
        if(retrofit==null)
        {
            Gson gson = new GsonBuilder().setLenient().create();

            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
