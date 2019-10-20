package com.zo0okadev.movieguide.ui.home.tvShowsAiringToday;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class TvShowsAiringTodayViewModel extends AndroidViewModel {

    private TvShowsRepository tvShowsRepository;
    private LiveData<PagedList<ListTvShow>> tvShowsAiringToday;

    public TvShowsAiringTodayViewModel(@NonNull Application application) {
        super(application);
        tvShowsRepository = new TvShowsRepository(application);
        tvShowsAiringToday = tvShowsRepository.getTvShowsAiringToday();
    }

    public LiveData<PagedList<ListTvShow>> getTvShowsAiringToday() {
        return tvShowsAiringToday;
    }
}
