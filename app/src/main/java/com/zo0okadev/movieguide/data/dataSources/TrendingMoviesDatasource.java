package com.zo0okadev.movieguide.data.dataSources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zo0okadev.movieguide.model.TrendingMovie;
import com.zo0okadev.movieguide.model.reponses.TrendingMoviesResponse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;

public class TrendingMoviesDatasource extends PageKeyedDataSource<Integer, TrendingMovie> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, TrendingMovie> callback) {
        RetrofitClient.getInstance().getTrendingMovies(API_KEY, 1).enqueue(new Callback<TrendingMoviesResponse>() {
            @Override
            public void onResponse(Call<TrendingMoviesResponse> call, Response<TrendingMoviesResponse> response) {
                if (response.isSuccessful()) {
                    List<TrendingMovie> trendingMovies;
                    if (response.body() != null) {
                        trendingMovies = response.body().getResults();
                    } else {
                        trendingMovies = Collections.emptyList();
                    }
                    callback.onResult(trendingMovies, null, 2);
                }
            }

            @Override
            public void onFailure(Call<TrendingMoviesResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, TrendingMovie> callback) {
        RetrofitClient.getInstance().getTrendingMovies(API_KEY, params.key).enqueue(new Callback<TrendingMoviesResponse>() {
            @Override
            public void onResponse(Call<TrendingMoviesResponse> call, Response<TrendingMoviesResponse> response) {
                if (response.isSuccessful()) {
                    List<TrendingMovie> trendingMovies;
                    if (response.body() != null) {
                        trendingMovies = response.body().getResults();
                    } else {
                        trendingMovies = Collections.emptyList();
                    }
                    callback.onResult(trendingMovies, params.key - 1);
                }
            }

            @Override
            public void onFailure(Call<TrendingMoviesResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, TrendingMovie> callback) {
        RetrofitClient.getInstance().getTrendingMovies(API_KEY, params.key).enqueue(new Callback<TrendingMoviesResponse>() {
            @Override
            public void onResponse(Call<TrendingMoviesResponse> call, Response<TrendingMoviesResponse> response) {
                RetrofitClient.getInstance().getTrendingMovies(API_KEY, params.key).enqueue(new Callback<TrendingMoviesResponse>() {
                    @Override
                    public void onResponse(Call<TrendingMoviesResponse> call, Response<TrendingMoviesResponse> response) {
                        if (response.isSuccessful()) {
                            List<TrendingMovie> trendingMovies;
                            if (response.body() != null) {
                                trendingMovies = response.body().getResults();
                            } else {
                                trendingMovies = Collections.emptyList();
                            }
                            callback.onResult(trendingMovies, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<TrendingMoviesResponse> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<TrendingMoviesResponse> call, Throwable t) {

            }
        });
    }
}
