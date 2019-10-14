package com.zo0okadev.movieguide.ui.movies;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<List<Genre>> movieGenres;

    public MoviesViewModel(Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
        movieGenres = moviesRepository.getMovieGenres();
    }

    public LiveData<List<Genre>> getMovieGenres() {
        return movieGenres;
    }

    public void loadMovieGenres() {
        moviesRepository.loadMovieGenres();
    }
}
