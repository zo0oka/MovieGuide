package com.zo0okadev.movieguide.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.db.MoviesDao;
import com.zo0okadev.movieguide.model.ListMovie;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FavoriteMoviesRepository {

    private MoviesDao moviesDao;
    private Executor executor;
    private LiveData<List<ListMovie>> favoriteMovies;

    public FavoriteMoviesRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        moviesDao = db.moviesDao();
        executor = Executors.newFixedThreadPool(5);
        favoriteMovies = moviesDao.getFavoriteMovies();
    }

    public void insertFavoriteMovie(ListMovie movie) {
        executor.execute(() -> moviesDao.insert(movie));
    }

    public void deleteFavoriteMovie(int id) {
        executor.execute(() -> moviesDao.deleteFavoriteMovie(id));
    }

    public LiveData<List<ListMovie>> getFavoriteMovies() {
        return favoriteMovies;
    }

    public LiveData<List<ListMovie>> isFavorite(int id) {
        return moviesDao.isFavorite(id);
    }
}
