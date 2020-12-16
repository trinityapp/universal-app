package com.example.largefilessendinglibrary.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static String host;

    public static void setHost(String hostRetrieved) {
        host = hostRetrieved;
    }

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(1, TimeUnit.HOURS);
        builder.connectTimeout(1, TimeUnit.HOURS);
        builder.writeTimeout(60, TimeUnit.MINUTES);
        OkHttpClient client = builder.addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (host != null) {
            HttpUrl newUrl = HttpUrl.parse(host);
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(newUrl)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
        }


        return retrofit;
    }
}
