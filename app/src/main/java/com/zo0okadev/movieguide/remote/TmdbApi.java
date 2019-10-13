package com.zo0okadev.movieguide.remote;

import com.zo0okadev.movieguide.model.reponses.TopRatedMoviesResonse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {

    @GET("movie/top_rated")
    Call<TopRatedMoviesResonse> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);
}
