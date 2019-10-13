package com.zo0okadev.movieguide.data.dataSourceFactories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zo0okadev.movieguide.data.dataSources.GenreMoviesDatasource;
import com.zo0okadev.movieguide.model.ListMovie;

public class GenreMoviesDatasourceFactory extends DataSource.Factory<Integer, ListMovie> {

    private int genreId;
    private static final String TAG = GenreMoviesDatasourceFactory.class.getSimpleName();

    public GenreMoviesDatasourceFactory(int genreId) {
        this.genreId = genreId;
    }

    @NonNull
    @Override
    public DataSource<Integer, ListMovie> create() {
        Log.d(TAG, "create: Genre ID: " + genreId);
        return new GenreMoviesDatasource(genreId);
    }
}
