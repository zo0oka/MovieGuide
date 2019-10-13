package com.zo0okadev.movieguide.ui.movies.movieGenres;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class MovieGenreViewModel extends ViewModel {

    private MoviesRepository moviesRepository;

    public MovieGenreViewModel() {
        moviesRepository = new MoviesRepository();
    }

    public LiveData<PagedList<ListMovie>> getGenreMovies(int genreId) {
        return moviesRepository.getGenreMovies(genreId);
    }
}
