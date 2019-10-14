package com.zo0okadev.movieguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.facebook.stetho.Stetho;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zo0okadev.movieguide.db.AppDB;
import com.zo0okadev.movieguide.ui.movies.MoviesViewModel;
import com.zo0okadev.movieguide.ui.tvShows.TvShowsViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Remove
        Stetho.initializeWithDefaults(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);


        //TODO: Implement First run
        ViewModelProviders.of(this).get(MoviesViewModel.class).loadMovieGenres();
        ViewModelProviders.of(this).get(TvShowsViewModel.class).loadTvShowGenres();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDB.destroyInstance();
    }
}
