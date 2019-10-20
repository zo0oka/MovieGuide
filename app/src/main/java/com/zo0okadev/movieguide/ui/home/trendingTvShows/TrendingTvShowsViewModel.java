package com.zo0okadev.movieguide.ui.home.trendingTvShows;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.TrendingTvShow;

public class TrendingTvShowsViewModel extends AndroidViewModel {

    private TvShowsRepository tvShowsRepository;
    private LiveData<PagedList<TrendingTvShow>> trendingTvShows;

    public TrendingTvShowsViewModel(@NonNull Application application) {
        super(application);
        tvShowsRepository = new TvShowsRepository(application);
        trendingTvShows = tvShowsRepository.getTrendingtvShows();
    }

    public LiveData<PagedList<TrendingTvShow>> getTrendingTvShows() {
        return trendingTvShows;
    }
}
