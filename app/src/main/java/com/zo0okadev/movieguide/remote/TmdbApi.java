package com.zo0okadev.movieguide.remote;

import com.zo0okadev.movieguide.model.reponses.MoviesListResonse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {

    @GET("movie/top_rated")
    Call<MoviesListResonse> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("movie/popular")
    Call<MoviesListResonse> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);
}
