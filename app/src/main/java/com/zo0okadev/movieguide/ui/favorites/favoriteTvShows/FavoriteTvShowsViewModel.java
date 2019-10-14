package com.zo0okadev.movieguide.ui.favorites.favoriteTvShows;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.FavoriteTvShowsRepository;
import com.zo0okadev.movieguide.model.ListTvShow;

import java.util.List;

public class FavoriteTvShowsViewModel extends AndroidViewModel {

    private FavoriteTvShowsRepository favoriteTvShowsRepository;
    private LiveData<PagedList<ListTvShow>> favoriteTvShows;

    public FavoriteTvShowsViewModel(@NonNull Application application) {
        super(application);
        favoriteTvShowsRepository = new FavoriteTvShowsRepository(application);
        favoriteTvShows = favoriteTvShowsRepository.getFavoriteTvShows();
    }

    public LiveData<PagedList<ListTvShow>> getFavoriteTvShows() {
        return favoriteTvShows;
    }

    public void insertFavoriteTvShow(ListTvShow tvShow) {
        favoriteTvShowsRepository.insertFavoriteTvShow(tvShow);
    }

    public void deleteFavoriteTvShow(int id) {
        favoriteTvShowsRepository.deleteFavoriteTvShow(id);
    }

    public LiveData<List<ListTvShow>> isFavorite(int id) {
        return favoriteTvShowsRepository.isFavorite(id);
    }
}
