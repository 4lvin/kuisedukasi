package com.jongjava.alvin.kuisgame.base;

import android.app.Application;


import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class MyApplication extends Application {
    private static OkHttpClient okHttpClient;


    public static final String BASE_URL = "http://31.220.55.149/admingame/master/android_api/";



    @Override
    public void onCreate() {
        super.onCreate();
//        Configuration.Builder confiBuilder = new Configuration.Builder(this);
//        confiBuilder.addModelClasses(Resi.class, Manifest.class, City.class, OngkirItem.class,
//                Favorit.class);
//        ActiveAndroid.initialize(this);
        okHttpClient = new OkHttpClient();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES);

        okHttpClient = builder.build();
    }

    public static OkHttpClient getClient() {
        return okHttpClient;
    }

}
