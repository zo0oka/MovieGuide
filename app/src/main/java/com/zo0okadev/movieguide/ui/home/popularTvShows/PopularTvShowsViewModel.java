package com.zo0okadev.movieguide.ui.home.popularTvShows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.HomeRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class PopularTvShowsViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private LiveData<PagedList<ListTvShow>> popularTvShows;

    public PopularTvShowsViewModel() {
        homeRepository = new HomeRepository();
        popularTvShows = homeRepository.getPopularTvShows();
    }

    public LiveData<PagedList<ListTvShow>> getPopularTvShows() {
        return popularTvShows;
    }
}
