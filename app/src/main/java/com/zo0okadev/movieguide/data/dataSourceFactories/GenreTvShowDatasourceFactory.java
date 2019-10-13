package com.zo0okadev.movieguide.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.GenreTvShowsDatasource;
import com.zo0okadev.movieguide.model.ListTvShow;

public class GenreTvShowDatasourceFactory extends DataSource.Factory<Integer, ListTvShow> {

    private int genreId;

    public GenreTvShowDatasourceFactory(int genreId) {
        this.genreId = genreId;
    }

    @NonNull
    @Override
    public DataSource<Integer, ListTvShow> create() {
        return new GenreTvShowsDatasource(genreId);
    }
}
