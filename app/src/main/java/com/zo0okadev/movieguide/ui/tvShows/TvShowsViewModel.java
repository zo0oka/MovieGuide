package com.zo0okadev.movieguide.ui.tvShows;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zo0okadev.movieguide.data.repositories.TvShowsRepository;
import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

public class TvShowsViewModel extends AndroidViewModel {

    private TvShowsRepository tvShowsRepository;
    private LiveData<List<Genre>> tvShowGenres;

    public TvShowsViewModel(Application application) {
        super(application);
        tvShowsRepository = new TvShowsRepository(application);
        tvShowGenres = tvShowsRepository.getTvshowGenres();
    }

    public LiveData<List<Genre>> getTvShowGenres() {
        return tvShowGenres;
    }

    public void loadTvShowGenres() {
        tvShowsRepository.loadTvShowGenres();
    }
}
