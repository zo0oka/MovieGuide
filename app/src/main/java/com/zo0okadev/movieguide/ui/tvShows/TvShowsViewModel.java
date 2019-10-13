package com.zo0okadev.movieguide.ui.tvShows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

public class TvShowsViewModel extends ViewModel {

    private TvShowsRepository tvShowsRepository;
    private LiveData<List<Genre>> tvShowGenres;

    public TvShowsViewModel() {
        tvShowsRepository = new TvShowsRepository();
        tvShowGenres = tvShowsRepository.getTvShowGenres();
    }

    public LiveData<List<Genre>> getTvShowGenres() {
        return tvShowGenres;
    }
}
