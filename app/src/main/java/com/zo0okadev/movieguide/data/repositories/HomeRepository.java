package com.zo0okadev.movieguide.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zo0okadev.movieguide.data.dataSourceFactories.PopularMoviesDatasourceFacroty;
import com.zo0okadev.movieguide.data.dataSourceFactories.TopRatedMoviesDatasourceFactory;
import com.zo0okadev.movieguide.model.ListMovie;

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

    public LiveData<PagedList<ListMovie>> getPopularMovies() {
        PopularMoviesDatasourceFacroty popularMoviesDatasourceFacroty = new PopularMoviesDatasourceFacroty();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setMaxSize(60)
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build();
        return new LivePagedListBuilder<>(popularMoviesDatasourceFacroty, config).build();
    }

}
