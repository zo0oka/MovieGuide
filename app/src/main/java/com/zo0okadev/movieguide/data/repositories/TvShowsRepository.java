package com.zo0okadev.movieguide.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.dataSourceFactories.GenreTvShowDatasourceFactory;
import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.db.GenreDao;
import com.zo0okadev.movieguide.model.Genre;
import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.model.reponses.GenresResponse;
import com.zo0okadev.movieguide.remote.RetrofitClient;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zo0okadev.movieguide.utils.Constants.API_KEY;
import static com.zo0okadev.movieguide.utils.Constants.LANGUAGE;

public class TvShowsRepository {

    private GenreDao genreDao;
    private LiveData<List<Genre>> tvshowGenres;
    private Executor executor;

    public TvShowsRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        genreDao = db.genreDao();
        tvshowGenres = genreDao.getTvShowGenres();
        executor = Executors.newFixedThreadPool(5);
    }

    public void loadTvShowGenres() {
        RetrofitClient.getInstance().getTvShowsGenres(API_KEY, LANGUAGE).enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Genre> genres = response.body().getGenres();
                        for (Genre genre : genres) {
                            genre.setType("tvShow");
                        }
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                genreDao.insertGenres(genres);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<List<Genre>> getTvshowGenres() {
        return tvshowGenres;
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
