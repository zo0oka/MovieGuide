package com.zo0okadev.movieguide.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.dataSourceFactories.GenreMoviesDatasourceFactory;
import com.zo0okadev.movieguide.data.dataSourceFactories.NowPlayingMoviesDatasourceFactory;
import com.zo0okadev.movieguide.data.dataSourceFactories.UpcomingMoviesDatasourceFactory;
import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.db.GenreDao;
import com.zo0okadev.movieguide.model.Genre;
import com.zo0okadev.movieguide.model.ListMovie;
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

public class MoviesRepository {

    private GenreDao genreDao;
    private Executor executor;
    private LiveData<List<Genre>> movieGenres;

    public MoviesRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        genreDao = db.genreDao();
        executor = Executors.newFixedThreadPool(5);
        movieGenres = genreDao.getMovieGenres();
    }

    public LiveData<List<Genre>> getMovieGenres() {
        return movieGenres;
    }

    public void loadMovieGenres() {
        RetrofitClient.getInstance().getMovieGenres(API_KEY, LANGUAGE)
                .enqueue(new Callback<GenresResponse>() {
                    @Override
                    public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                List<Genre> genreList = response.body().getGenres();
                                for (Genre genre : genreList) {
                                    genre.setType("movie");
                                }
                                executor.execute(() -> genreDao.insertGenres(genreList));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GenresResponse> call, Throwable t) {

                    }
                });
    }

    public LiveData<PagedList<ListMovie>> getNowPlayingMovies() {
        NowPlayingMoviesDatasourceFactory nowPlayingMoviesDatasourceFactory = new NowPlayingMoviesDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(nowPlayingMoviesDatasourceFactory, config).build();
    }

    public LiveData<PagedList<ListMovie>> getGenreMovies(int genreId) {
        GenreMoviesDatasourceFactory genreMoviesDatasourceFactory = new GenreMoviesDatasourceFactory(genreId);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(genreMoviesDatasourceFactory, config).build();
    }

    public LiveData<PagedList<ListMovie>> getUpcomingMovies() {
        UpcomingMoviesDatasourceFactory upcomingMoviesDatasourceFactory = new UpcomingMoviesDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(upcomingMoviesDatasourceFactory, config).build();
    }

}
