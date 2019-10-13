package com.zo0okadev.movieguide.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.dataSourceFactories.GenreTvShowDatasourceFactory;
import com.zo0okadev.movieguide.model.Genre;
import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.model.reponses.GenresResponse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;
import static com.zo0okadev.movieguide.utils.Constants.LANGUAGE;

public class TvShowsRepository {

    public LiveData<List<Genre>> getTvShowGenres() {
        MutableLiveData<List<Genre>> genres = new MutableLiveData<>();
        RetrofitClient.getInstance().getTvShowsGenres(API_KEY, LANGUAGE).enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                if (response.isSuccessful()) {
                    List<Genre> genreList;
                    if (response.body() != null) {
                        genreList = response.body().getGenres();
                    } else {
                        genreList = Collections.emptyList();
                    }
                    genres.postValue(genreList);
                }
            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {

            }
        });
        return genres;
    }

    public LiveData<PagedList<ListTvShow>> getGenreTvShows(int genreId) {
        GenreTvShowDatasourceFactory genreTvShowDatasourceFactory = new GenreTvShowDatasourceFactory(genreId);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(genreTvShowDatasourceFactory, config).build();
    }
}
