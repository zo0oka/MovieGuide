package com.zo0okadev.movieguide.db;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.zo0okadev.movieguide.model.ListTvShow;

import java.util.List;

@Dao
public interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ListTvShow tvShow);

    @Query("SELECT * FROM favorite_tv_shows")
    DataSource.Factory<Integer, ListTvShow> getFavoriteTvShows();

    @Query("DELETE FROM favorite_tv_shows WHERE id = :id")
    void deleteFavoriteTvShow(int id);

    @Query("SELECT * FROM favorite_tv_shows WHERE id = :id")
    LiveData<List<ListTvShow>> isFavorite(int id);
}
