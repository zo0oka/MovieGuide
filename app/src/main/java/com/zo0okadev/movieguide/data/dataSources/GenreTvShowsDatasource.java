package com.zo0okadev.movieguide.data.dataSources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.model.reponses.TvShowsListResponse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;
import static com.zo0okadev.movieguide.utils.Constants.LANGUAGE;
import static com.zo0okadev.movieguide.utils.Constants.PRIMARY_RELEASE_DATE_DESC;

public class GenreTvShowsDatasource extends PageKeyedDataSource<Integer, ListTvShow> {

    private int genreId;

    public GenreTvShowsDatasource(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ListTvShow> callback) {
        RetrofitClient.getInstance().getGenreTvShows(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId, 1)
                .enqueue(new Callback<TvShowsListResponse>() {
                    @Override
                    public void onResponse(Call<TvShowsListResponse> call, Response<TvShowsListResponse> response) {
                        if (response.isSuccessful()) {
                            List<ListTvShow> tvShows;
                            if (response.body() != null) {
                                tvShows = response.body().getResults();
                            } else {
                                tvShows = Collections.emptyList();
                            }
                            callback.onResult(tvShows, null, 2);
                        }
                    }

                    @Override
                    public void onFailure(Call<TvShowsListResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListTvShow> callback) {
        RetrofitClient.getInstance().getGenreTvShows(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId, params.key)
                .enqueue(new Callback<TvShowsListResponse>() {
                    @Override
                    public void onResponse(Call<TvShowsListResponse> call, Response<TvShowsListResponse> response) {
                        if (response.isSuccessful()) {
                            List<ListTvShow> tvShows;
                            if (response.body() != null) {
                                tvShows = response.body().getResults();
                            } else {
                                tvShows = Collections.emptyList();
                            }
                            callback.onResult(tvShows, params.key - 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<TvShowsListResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListTvShow> callback) {
        RetrofitClient.getInstance().getGenreTvShows(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId, params.key)
                .enqueue(new Callback<TvShowsListResponse>() {
                    @Override
                    public void onResponse(Call<TvShowsListResponse> call, Response<TvShowsListResponse> response) {
                        if (response.isSuccessful()) {
                            List<ListTvShow> tvShows;
                            if (response.body() != null) {
                                tvShows = response.body().getResults();
                            } else {
                                tvShows = Collections.emptyList();
                            }
                            callback.onResult(tvShows, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<TvShowsListResponse> call, Throwable t) {

                    }
                });
    }
}
