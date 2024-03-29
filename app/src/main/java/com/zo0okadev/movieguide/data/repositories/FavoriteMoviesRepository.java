package com.zo0okadev.movieguide.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.db.MoviesDao;
import com.zo0okadev.movieguide.model.ListMovie;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FavoriteMoviesRepository {

    private MoviesDao moviesDao;
    private Executor executor;
    private LiveData<PagedList<ListMovie>> favoriteMovies;

    public FavoriteMoviesRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        moviesDao = db.moviesDao();
        executor = Executors.newFixedThreadPool(5);
    }

    public void insertFavoriteMovie(ListMovie movie) {
        executor.execute(() -> moviesDao.insert(movie));
    }

    public void deleteFavoriteMovie(int id) {
        executor.execute(() -> moviesDao.deleteFavoriteMovie(id));
    }

    public LiveData<PagedList<ListMovie>> getFavoriteMovies() {
        DataSource.Factory<Integer, ListMovie> factory = moviesDao.getFavoriteMovies();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(factory, config).build();
    }

    public LiveData<List<ListMovie>> isFavorite(int id) {
        return moviesDao.isFavorite(id);
    }
}
