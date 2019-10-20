package com.zo0okadev.movieguide.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.TrendingMoviesDatasource;
import com.zo0okadev.movieguide.model.TrendingMovie;

public class TrendingMoviesDatasourceFactory extends DataSource.Factory<Integer, TrendingMovie> {
    @NonNull
    @Override
    public DataSource<Integer, TrendingMovie> create() {
        return new TrendingMoviesDatasource();
    }
}
