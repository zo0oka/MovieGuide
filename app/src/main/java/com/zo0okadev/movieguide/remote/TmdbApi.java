package com.zo0okadev.movieguide.remote;

import com.zo0okadev.movieguide.model.reponses.GenresResponse;
import com.zo0okadev.movieguide.model.reponses.MoviesListResonse;
import com.zo0okadev.movieguide.model.reponses.NowPlayingMoviesResponse;
import com.zo0okadev.movieguide.model.reponses.TrendingMoviesResponse;
import com.zo0okadev.movieguide.model.reponses.TrendingTvShowsResponse;
import com.zo0okadev.movieguide.model.reponses.TvShowsListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {

    @GET("movie/top_rated")
    Call<MoviesListResonse> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("tv/top_rated")
    Call<TvShowsListResponse> getTopRatedTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("movie/popular")
    Call<MoviesListResonse> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("movie/now_playing")
    Call<NowPlayingMoviesResponse> getNowPlayingMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("movie/upcoming")
    Call<MoviesListResonse> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("tv/popular")
    Call<TvShowsListResponse> getPopularTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("trending/movie/week")
    Call<TrendingMoviesResponse> getTrendingMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("trending/tv/week")
    Call<TrendingTvShowsResponse> getTrendingTvShows(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("tv/airing_today")
    Call<TvShowsListResponse> getTvShowsAiringToday(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("tv/on_the_air")
    Call<TvShowsListResponse> getTvShowsOnTheAir(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    @GET("genre/movie/list")
    Call<GenresResponse> getMovieGenres(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("genre/tv/list")
    Call<GenresResponse> getTvShowsGenres(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("discover/movie")
    Call<MoviesListResonse> getGenreMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String sortBy,
            @Query("with_genres") int genre,
            @Query("page") int page);

    @GET("discover/tv")
    Call<TvShowsListResponse> getGenreTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String sortBy,
            @Query("with_genres") int genre,
            @Query("page") int page);
}
