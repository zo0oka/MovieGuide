package com.zo0okadev.movieguide.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.dataSourceFactories.PopularMoviesDatasourceFactory;
import com.zo0okadev.movieguide.data.dataSourceFactories.PopularTvShowsDatasourceFactory;
import com.zo0okadev.movieguide.data.dataSourceFactories.TopRatedMoviesDatasourceFactory;
import com.zo0okadev.movieguide.data.dataSourceFactories.TopRatedTvShowsDatasourceFactory;
import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.model.ListTvShow;

public class HomeRepository {

    public LiveData<PagedList<ListMovie>> getTopRatedMovies() {
        TopRatedMoviesDatasourceFactory topRatedMoviesDatasourceFactory = new TopRatedMoviesDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(topRatedMoviesDatasourceFactory, config).build();
    }

    public LiveData<PagedList<ListTvShow>> getTopRatedTvShows() {
        TopRatedTvShowsDatasourceFactory topRatedTvShowsDatasourceFactory = new TopRatedTvShowsDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(topRatedTvShowsDatasourceFactory, config).build();
    }

    public LiveData<PagedList<ListMovie>> getPopularMovies() {
        PopularMoviesDatasourceFactory popularMoviesDatasourceFactory = new PopularMoviesDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(popularMoviesDatasourceFactory, config).build();
    }

    public LiveData<PagedList<ListTvShow>> getPopularTvShows() {
        PopularTvShowsDatasourceFactory popularTvShowsDatasourceFactory = new PopularTvShowsDatasourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(popularTvShowsDatasourceFactory, config).build();
    }

}
