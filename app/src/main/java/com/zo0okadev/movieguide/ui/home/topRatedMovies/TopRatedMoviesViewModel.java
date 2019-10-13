package com.zo0okadev.movieguide.ui.home.topRatedMovies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.HomeRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class TopRatedMoviesViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private LiveData<PagedList<ListMovie>> topRatedMovies;

    public TopRatedMoviesViewModel() {
        homeRepository = new HomeRepository();
        topRatedMovies = homeRepository.getTopRatedMovies();
    }

    public LiveData<PagedList<ListMovie>> getTopRatedMovies() {
        return topRatedMovies;
    }
}
