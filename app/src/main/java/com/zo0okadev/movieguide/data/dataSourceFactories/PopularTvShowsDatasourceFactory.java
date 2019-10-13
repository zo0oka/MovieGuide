package com.zo0okadev.movieguide.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.PopularTvShowsDatasource;
import com.zo0okadev.movieguide.model.ListTvShow;

public class PopularTvShowsDatasourceFactory extends DataSource.Factory<Integer, ListTvShow> {

    @NonNull
    @Override
    public DataSource<Integer, ListTvShow> create() {
        return new PopularTvShowsDatasource();
    }
}
