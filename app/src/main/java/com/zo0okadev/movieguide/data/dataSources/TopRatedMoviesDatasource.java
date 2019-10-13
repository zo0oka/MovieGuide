package com.zo0okadev.movieguide.data.dataSources;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.model.reponses.TopRatedMoviesResonse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;
import static com.zo0okadev.movieguide.utils.Constants.LANGUAGE;

public class TopRatedMoviesDatasource extends PageKeyedDataSource<Integer, ListMovie> {

    private static final String TAG = TopRatedMoviesDatasource.class.getSimpleName();
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getTopRatedMovies(API_KEY, LANGUAGE, 1).enqueue(new Callback<TopRatedMoviesResonse>() {
            @Override
            public void onResponse(Call<TopRatedMoviesResonse> call, Response<TopRatedMoviesResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> movies;
                    if (response.body() != null) {
                        movies = response.body().getResults();
                        Log.d(TAG, "onResponse: Movies count: " + movies.size());
                    } else {
                        movies = Collections.emptyList();
                    }
                    callback.onResult(movies, null, 2);
                }
            }

            @Override
            public void onFailure(Call<TopRatedMoviesResonse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getTopRatedMovies(API_KEY, LANGUAGE, params.key).enqueue(new Callback<TopRatedMoviesResonse>() {
            @Override
            public void onResponse(Call<TopRatedMoviesResonse> call, Response<TopRatedMoviesResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> movies;
                    if (response.body() != null) {
                        movies = response.body().getResults();
                    } else {
                        movies = Collections.emptyList();
                    }
                    callback.onResult(movies, params.key - 1);
                }
            }

            @Override
            public void onFailure(Call<TopRatedMoviesResonse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getTopRatedMovies(API_KEY, LANGUAGE, params.key).enqueue(new Callback<TopRatedMoviesResonse>() {
            @Override
            public void onResponse(Call<TopRatedMoviesResonse> call, Response<TopRatedMoviesResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> movies;
                    if (response.body() != null) {
                        movies = response.body().getResults();
                    } else {
                        movies = Collections.emptyList();
                    }
                    callback.onResult(movies, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<TopRatedMoviesResonse> call, Throwable t) {

            }
        });
    }
}
