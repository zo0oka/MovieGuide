package com.zo0okadev.movieguide.ui.movies.upcomingMovies;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class UpcomingMoviesViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<PagedList<ListMovie>> upcomingMovies;

    public UpcomingMoviesViewModel(Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
        upcomingMovies = moviesRepository.getUpcomingMovies();
    }

    public LiveData<PagedList<ListMovie>> getUpcomingMovies() {
        return upcomingMovies;
    }
}
