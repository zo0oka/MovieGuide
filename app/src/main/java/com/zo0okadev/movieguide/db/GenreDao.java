package com.zo0okadev.movieguide.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

@Dao
public interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGenres(List<Genre> genres);

    @Query("SELECT * FROM genres WHERE type = 'movie'")
    LiveData<List<Genre>> getMovieGenres();

    @Query("SELECT * FROM genres WHERE type = 'tvShow'")
    LiveData<List<Genre>> getTvShowGenres();
}
