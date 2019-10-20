package com.zo0okadev.movieguide.ui.home.trendingMovies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.TrendingMovie;

public class TrendingMoviesViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<PagedList<TrendingMovie>> trendingMovies;

    public TrendingMoviesViewModel(@NonNull Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
        trendingMovies = moviesRepository.getTrendingMovies();
    }

    public LiveData<PagedList<TrendingMovie>> getTrendingMovies() {
        return trendingMovies;
    }
}