package com.zo0okadev.movieguide.ui.movies.upcomingMovies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class UpcomingMoviesViewModel extends ViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<PagedList<ListMovie>> upcomingMovies;

    public UpcomingMoviesViewModel() {
        moviesRepository = new MoviesRepository();
        upcomingMovies = moviesRepository.getUpcomingMovies();
    }

    public LiveData<PagedList<ListMovie>> getUpcomingMovies() {
        return upcomingMovies;
    }
}
