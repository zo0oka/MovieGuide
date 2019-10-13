package com.zo0okadev.movieguide.data.dataSources;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.model.reponses.MoviesListResonse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;
import static com.zo0okadev.movieguide.utils.Constants.LANGUAGE;

public class UpcomingMoviesDatasource extends PageKeyedDataSource<Integer, ListMovie> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getUpcomingMovies(API_KEY, LANGUAGE, 1).enqueue(new Callback<MoviesListResonse>() {
            @Override
            public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> upcomingMovies;
                    if (response.body() != null) {
                        upcomingMovies = response.body().getResults();
                    } else {
                        upcomingMovies = Collections.emptyList();
                    }
                    callback.onResult(upcomingMovies, null, 2);
                }
            }

            @Override
            public void onFailure(Call<MoviesListResonse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getUpcomingMovies(API_KEY, LANGUAGE, params.key).enqueue(new Callback<MoviesListResonse>() {
            @Override
            public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> upcomingMovies;
                    if (response.body() != null) {
                        upcomingMovies = response.body().getResults();
                    } else {
                        upcomingMovies = Collections.emptyList();
                    }
                    callback.onResult(upcomingMovies, params.key - 1);
                }
            }

            @Override
            public void onFailure(Call<MoviesListResonse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getUpcomingMovies(API_KEY, LANGUAGE, params.key).enqueue(new Callback<MoviesListResonse>() {
            @Override
            public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                if (response.isSuccessful()) {
                    List<ListMovie> upcomingMovies;
                    if (response.body() != null) {
                        upcomingMovies = response.body().getResults();
                    } else {
                        upcomingMovies = Collections.emptyList();
                    }
                    callback.onResult(upcomingMovies, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<MoviesListResonse> call, Throwable t) {

            }
        });
    }
}
