package com.example.developer.sortedstreets.retrofit;

import android.text.TextUtils;

import com.example.developer.sortedstreets.SortedStreetsApplication;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import lombok.Getter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static Retrofit sRetrofit;

    @Getter
    private static SortedStreetsApplication service;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });

        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);

        // Add headers
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //TODO:: Get the application token and use it here
                String token = "";
                int id = -1;
                if (!TextUtils.isEmpty(token) && id != -1) {
                    request = request.newBuilder()
                            .addHeader("Authorization", "")
                            .addHeader("auth_token", token)
                            .url(request.url().newBuilder().build()).build();

                } else {
                    request = request.newBuilder()
                            .addHeader("Authorization", "")
                            .url(request.url().newBuilder().build()).build();
                }
                return chain.proceed(request);

            }
        });

        // Logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.interceptors().add(interceptor);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd")
                .create();

        sRetrofit = new Retrofit.Builder()
               // .baseUrl(BuildConfig.BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        //service = sRetrofit.create(NextCuresService.class);
    }
}