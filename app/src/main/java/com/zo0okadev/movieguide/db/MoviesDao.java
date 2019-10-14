package com.zo0okadev.movieguide.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.zo0okadev.movieguide.model.ListMovie;

import java.util.List;

@Dao
public interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ListMovie movie);

    @Query("SELECT * FROM favorite_movies")
    LiveData<List<ListMovie>> getFavoriteMovies();

    @Query("DELETE FROM favorite_movies WHERE id = :id")
    void deleteFavoriteMovie(int id);

    @Query("SELECT * FROM favorite_movies WHERE id = :id")
    LiveData<List<ListMovie>> isFavorite(int id);
}
