package com.zo0okadev.movieguide.data.dataSources;

import android.util.Log;

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
import static com.zo0okadev.movieguide.utils.Constants.PRIMARY_RELEASE_DATE_DESC;

public class GenreMoviesDatasource extends PageKeyedDataSource<Integer, ListMovie> {

    private int genreId;
    private static final String TAG = GenreMoviesDatasource.class.getSimpleName();

    public GenreMoviesDatasource(int genreId) {
        this.genreId = genreId;
        Log.d(TAG, "GenreMoviesDatasource: Genre ID: " +genreId);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getGenreMovies(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId,1)
                .enqueue(new Callback<MoviesListResonse>() {
                    @Override
                    public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                        if (response.isSuccessful()) {
                            List<ListMovie> genreMovies;
                            if (response.body() != null) {
                                genreMovies = response.body().getResults();
                            } else {
                                genreMovies = Collections.emptyList();
                            }
                            callback.onResult(genreMovies, null, 2);
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesListResonse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getGenreMovies(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId,params.key)
                .enqueue(new Callback<MoviesListResonse>() {
                    @Override
                    public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                        if (response.isSuccessful()) {
                            List<ListMovie> genreMovies;
                            if (response.body() != null) {
                                genreMovies = response.body().getResults();
                            } else {
                                genreMovies = Collections.emptyList();
                            }
                            callback.onResult(genreMovies, params.key - 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesListResonse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListMovie> callback) {
        RetrofitClient.getInstance().getGenreMovies(API_KEY, LANGUAGE, PRIMARY_RELEASE_DATE_DESC, genreId,params.key)
                .enqueue(new Callback<MoviesListResonse>() {
                    @Override
                    public void onResponse(Call<MoviesListResonse> call, Response<MoviesListResonse> response) {
                        if (response.isSuccessful()) {
                            List<ListMovie> genreMovies;
                            if (response.body() != null) {
                                genreMovies = response.body().getResults();
                            } else {
                                genreMovies = Collections.emptyList();
                            }
                            callback.onResult(genreMovies, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesListResonse> call, Throwable t) {

                    }
                });
    }
}
