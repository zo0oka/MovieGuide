package com.zo0okadev.movieguide.ui.favorites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zo0okadev.movieguide.data.repositories.FavoriteMoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

import java.util.List;

public class FavoriteMoviesViewModel extends AndroidViewModel {

    private FavoriteMoviesRepository favoriteMoviesRepository;
    private LiveData<List<ListMovie>> favoriteMovies;

    public FavoriteMoviesViewModel(@NonNull Application application) {
        super(application);
        favoriteMoviesRepository = new FavoriteMoviesRepository(application);
        favoriteMovies = favoriteMoviesRepository.getFavoriteMovies();
    }

    public LiveData<List<ListMovie>> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void insertFavoriteMovie(ListMovie movie) {
        favoriteMoviesRepository.insertFavoriteMovie(movie);
    }

    public void deleteFavoriteMovie(int id) {
        favoriteMoviesRepository.deleteFavoriteMovie(id);
    }

    public LiveData<List<ListMovie>> isFavorite(int id) {
        return favoriteMoviesRepository.isFavorite(id);
    }
}
