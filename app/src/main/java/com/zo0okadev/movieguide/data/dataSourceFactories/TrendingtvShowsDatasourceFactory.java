package com.zo0okadev.movieguide.data.dataSourceFactories;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.TrendingTvShowsDatasource;
import com.zo0okadev.movieguide.model.TrendingTvShow;

public class TrendingtvShowsDatasourceFactory extends DataSource.Factory<Integer, TrendingTvShow> {
    @NonNull
    @Override
    public DataSource<Integer, TrendingTvShow> create() {
        return new TrendingTvShowsDatasource();
    }
}
