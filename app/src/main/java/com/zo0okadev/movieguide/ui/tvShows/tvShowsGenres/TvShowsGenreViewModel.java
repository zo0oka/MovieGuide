package com.zo0okadev.movieguide.ui.tvShows.tvShowsGenres;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class TvShowsGenreViewModel extends AndroidViewModel {

    private TvShowsRepository tvShowsRepository;

    public TvShowsGenreViewModel(Application application) {
        super(application);
        tvShowsRepository = new TvShowsRepository(application);
    }

    public LiveData<PagedList<ListTvShow>> getGenreTvShows(int genreId) {
        return tvShowsRepository.getGenreTvShows(genreId);
    }
}
