package com.sky.exercise.base;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {

    protected static Object retrofitCreate(Class aClass, String url) {
        okhttp3.OkHttpClient.Builder clientBuilder = new okhttp3.OkHttpClient().newBuilder();
        clientBuilder.readTimeout(30, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS);

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.d("Log", message);
//            }
//        });
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        clientBuilder.addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(clientBuilder.build())
                .baseUrl("https://" + url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(aClass);
    }
}
