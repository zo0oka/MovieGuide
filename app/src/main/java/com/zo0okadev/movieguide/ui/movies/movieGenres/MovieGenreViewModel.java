package com.zo0okadev.movieguide.ui.movies.movieGenres;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class MovieGenreViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;

    public MovieGenreViewModel(Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
    }

    public LiveData<PagedList<ListMovie>> getGenreMovies(int genreId) {
        return moviesRepository.getGenreMovies(genreId);
    }
}
