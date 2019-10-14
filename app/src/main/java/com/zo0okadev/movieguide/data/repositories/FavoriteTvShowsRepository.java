package com.zo0okadev.movieguide.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.db.TvShowsDao;
import com.zo0okadev.movieguide.model.ListTvShow;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FavoriteTvShowsRepository {

    private TvShowsDao tvShowsDao;
    private Executor executor;
    private LiveData<PagedList<ListTvShow>> favoriteTvShows;

    public FavoriteTvShowsRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        tvShowsDao = db.tvShowsDao();
        executor = Executors.newFixedThreadPool(5);
    }

    public void insertFavoriteTvShow(ListTvShow tvShow) {
        executor.execute(() -> tvShowsDao.insert(tvShow));
    }

    public void deleteFavoriteTvShow(int id) {
        executor.execute(() -> tvShowsDao.deleteFavoriteTvShow(id));
    }

    public LiveData<PagedList<ListTvShow>> getFavoriteTvShows() {
        DataSource.Factory<Integer, ListTvShow> factory = tvShowsDao.getFavoriteTvShows();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(factory, config).build();
    }

    public LiveData<List<ListTvShow>> isFavorite(int id) {
        return tvShowsDao.isFavorite(id);
    }
}
