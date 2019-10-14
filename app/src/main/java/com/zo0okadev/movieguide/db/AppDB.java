package com.zo0okadev.movieguide.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.zo0okadev.movieguide.model.Genre;
import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.model.ListTvShow;

@Database(entities = {Genre.class, ListMovie.class, ListTvShow.class}, version = 3, exportSchema = false)
@TypeConverters({com.zo0okadev.movieguide.db.TypeConverters.class})
public abstract class AppDB extends RoomDatabase {

    private static volatile AppDB INSTANCE;

    public static AppDB getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDB.class,
                            "movie_guide_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract GenreDao genreDao();
    public abstract MoviesDao moviesDao();
    public abstract TvShowsDao tvShowsDao();
}
