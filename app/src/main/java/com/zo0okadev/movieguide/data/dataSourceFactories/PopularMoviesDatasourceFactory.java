package com.zo0okadev.movieguide.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.PopularMoviesDatasource;
import com.zo0okadev.movieguide.model.ListMovie;

public class PopularMoviesDatasourceFactory extends DataSource.Factory<Integer, ListMovie> {

    @NonNull
    @Override
    public DataSource<Integer, ListMovie> create() {
        return new PopularMoviesDatasource();
    }
}
