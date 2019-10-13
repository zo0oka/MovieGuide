package com.zo0okadev.movieguide.ui.home.popularMovies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.HomeRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class PopularMoviesViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private LiveData<PagedList<ListMovie>> popularMovies;

    public PopularMoviesViewModel() {
        homeRepository = new HomeRepository();
        popularMovies = homeRepository.getPopularMovies();
    }

    public LiveData<PagedList<ListMovie>> getPopularMovies() {
        return popularMovies;
    }
}
