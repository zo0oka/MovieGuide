package com.zo0okadev.movieguide.ui.home.tvShowsOnTheAir;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class TvShowsOnTheAirViewModel extends AndroidViewModel {

    private TvShowsRepository tvShowsRepository;
    private LiveData<PagedList<ListTvShow>> tvShowsOnTheAir;

    public TvShowsOnTheAirViewModel(@NonNull Application application) {
        super(application);
        tvShowsRepository = new TvShowsRepository(application);
        tvShowsOnTheAir = tvShowsRepository.getTvShowsOnTheAir();
    }

    public LiveData<PagedList<ListTvShow>> getTvShowsOnTheAir() {
        return tvShowsOnTheAir;
    }
}
