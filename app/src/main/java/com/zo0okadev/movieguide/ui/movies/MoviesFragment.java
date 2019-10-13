package com.zo0okadev.movieguide.ui.movies;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.Genre;
import com.zo0okadev.movieguide.ui.adapters.SectionsPagerAdapter;
import com.zo0okadev.movieguide.ui.movies.movieGenres.MovieGenreFragment;
import com.zo0okadev.movieguide.ui.movies.nowPlayingMovies.NowPlayingMoviesFragment;
import com.zo0okadev.movieguide.ui.movies.trendingMovies.TrendingMoviesFragment;
import com.zo0okadev.movieguide.ui.movies.upcomingMovies.UpcomingMoviesFragment;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private MoviesViewModel viewModel;
    private static final String TAG = MoviesFragment.class.getSimpleName();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);

        initToolbar(rootView);

        initComponent(rootView);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_homeFragment, R.id.nav_moviesFragment, R.id.nav_tvShowsFragment, R.id.nav_celebsFragment, R.id.nav_searchFragment)
                .build();
        NavController navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(((AppCompatActivity) getActivity()), navController, appBarConfiguration);

        return rootView;
    }

    private void initToolbar(View rootView) {
        Toolbar toolbar = rootView.findViewById(R.id.movies_toolbar);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
    }

    private void initComponent(View rootView) {
        ViewPager view_pager = rootView.findViewById(R.id.movies_view_pager);
        setupViewPager(view_pager);

        TabLayout tab_layout = rootView.findViewById(R.id.movies_tab_layout);
        tab_layout.setupWithViewPager(view_pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());

        viewModel.getMovieGenres().observe(this, genres -> {
            adapter.addFragment(UpcomingMoviesFragment.newInstance(), "UPCOMING MOVIES");
            adapter.addFragment(NowPlayingMoviesFragment.newInstance(), "NOW PLAYING MOVIES");
            adapter.addFragment(TrendingMoviesFragment.newInstance(), "TRENDING MOVIES");

            for (Genre genre : genres) {
                adapter.addFragment(MovieGenreFragment.newInstance(genre.getId()), genre.getName().toUpperCase());
                Log.d(TAG, "setupViewPager: Genre ID: " + genre.getId());
            }
            viewPager.setAdapter(adapter);
        });
    }
}
