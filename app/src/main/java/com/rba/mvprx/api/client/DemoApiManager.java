package com.rba.mvprx.api.client;

import com.rba.mvprx.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class DemoApiManager {

    private static DemoApi demoApi ;

    public static DemoApi apiManager() {

        if(demoApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

            demoApi = client.create(DemoApi.class);
        }

        return demoApi;
    }

}
