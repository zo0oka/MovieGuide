package com.zo0okadev.movieguide.ui.home.topRatedTvShows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.HomeRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class TopRatedTvShowsViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private LiveData<PagedList<ListTvShow>> topRatedTvShows;

    public TopRatedTvShowsViewModel() {
        homeRepository = new HomeRepository();
        topRatedTvShows = homeRepository.getTopRatedTvShows();
    }

    public LiveData<PagedList<ListTvShow>> getTopRatedTvShows() {
        return topRatedTvShows;
    }
}
