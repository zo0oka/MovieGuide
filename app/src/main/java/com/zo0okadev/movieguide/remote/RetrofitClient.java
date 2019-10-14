package com.zo0okadev.movieguide.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zo0okadev.movieguide.utils.Constants.API_BASE_URL;

public class RetrofitClient {

    private static TmdbApi tmdbApi = null;

    public static TmdbApi getInstance() {

        if (tmdbApi == null) {

            // For logging
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            // Retrofit Builder
            Retrofit.Builder builder =
                    new Retrofit
                            .Builder()
                            .baseUrl(API_BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create(gson));

            tmdbApi = builder.build().create(TmdbApi.class);
        }
        return tmdbApi;
    }
}
