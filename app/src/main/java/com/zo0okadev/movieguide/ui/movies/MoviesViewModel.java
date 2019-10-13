package com.zo0okadev.movieguide.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<List<Genre>> movieGenres;

    public MoviesViewModel() {
        moviesRepository = new MoviesRepository();
        movieGenres = moviesRepository.getMovieGenres();
    }

    public LiveData<List<Genre>> getMovieGenres() {
        return movieGenres;
    }
}
