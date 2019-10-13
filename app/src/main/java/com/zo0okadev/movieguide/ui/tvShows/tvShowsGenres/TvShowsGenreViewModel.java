package com.zo0okadev.movieguide.ui.tvShows.tvShowsGenres;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

public class TvShowsGenreViewModel extends ViewModel {

    private TvShowsRepository tvShowsRepository;

    public TvShowsGenreViewModel() {
        tvShowsRepository = new TvShowsRepository();
    }

    public LiveData<PagedList<ListTvShow>> getGenreTvShows(int genreId) {
        return tvShowsRepository.getGenreTvShows(genreId);
    }
}
