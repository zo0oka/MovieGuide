package com.zo0okadev.movieguide.data.dataSources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zo0okadev.movieguide.model.TrendingTvShow;
import com.zo0okadev.movieguide.model.reponses.TrendingTvShowsResponse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;

public class TrendingTvShowsDatasource extends PageKeyedDataSource<Integer, TrendingTvShow> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, TrendingTvShow> callback) {
        RetrofitClient.getInstance().getTrendingTvShows(API_KEY, 1).enqueue(new Callback<TrendingTvShowsResponse>() {
            @Override
            public void onResponse(Call<TrendingTvShowsResponse> call, Response<TrendingTvShowsResponse> response) {
                if (response.isSuccessful()) {
                    List<TrendingTvShow> trendingTvShows;
                    if (response.body() != null) {
                        trendingTvShows = response.body().getResults();
                    } else {
                        trendingTvShows = Collections.emptyList();
                    }
                    callback.onResult(trendingTvShows, null, 2);
                }
            }

            @Override
            public void onFailure(Call<TrendingTvShowsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, TrendingTvShow> callback) {
        RetrofitClient.getInstance().getTrendingTvShows(API_KEY, params.key).enqueue(new Callback<TrendingTvShowsResponse>() {
            @Override
            public void onResponse(Call<TrendingTvShowsResponse> call, Response<TrendingTvShowsResponse> response) {
                if (response.isSuccessful()) {
                    List<TrendingTvShow> trendingTvShows;
                    if (response.body() != null) {
                        trendingTvShows = response.body().getResults();
                    } else {
                        trendingTvShows = Collections.emptyList();
                    }
                    callback.onResult(trendingTvShows, params.key - 1);
                }
            }

            @Override
            public void onFailure(Call<TrendingTvShowsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, TrendingTvShow> callback) {
        RetrofitClient.getInstance().getTrendingTvShows(API_KEY, params.key).enqueue(new Callback<TrendingTvShowsResponse>() {
            @Override
            public void onResponse(Call<TrendingTvShowsResponse> call, Response<TrendingTvShowsResponse> response) {
                if (response.isSuccessful()) {
                    List<TrendingTvShow> trendingTvShows;
                    if (response.body() != null) {
                        trendingTvShows = response.body().getResults();
                    }else {
                        trendingTvShows = Collections.emptyList();
                    }
                    callback.onResult(trendingTvShows, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<TrendingTvShowsResponse> call, Throwable t) {

            }
        });
    }
}
