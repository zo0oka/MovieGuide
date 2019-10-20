package com.zo0okadev.movieguide.ui.home.nowPlayingMovies;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.repositories.MoviesRepository;
import com.zo0okadev.movieguide.model.ListMovie;

public class NowPlayingMoviesViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<PagedList<ListMovie>> nowPlayingMovies;

    public NowPlayingMoviesViewModel(Application application) {
        super(application);
        moviesRepository = new MoviesRepository(application);
        nowPlayingMovies = moviesRepository.getNowPlayingMovies();
    }

    public LiveData<PagedList<ListMovie>> getNowPlayingMovies() {
        return nowPlayingMovies;
    }
}
