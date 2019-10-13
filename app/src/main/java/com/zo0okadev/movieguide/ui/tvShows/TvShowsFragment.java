package com.zo0okadev.movieguide.ui.tvShows;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
import com.zo0okadev.movieguide.ui.tvShows.TvShowsAiringToday.TvShowsAiringTodayFragment;
import com.zo0okadev.movieguide.ui.tvShows.trendingTvShows.TrendingTvShowsFragment;
import com.zo0okadev.movieguide.ui.tvShows.tvShowsGenres.TvShowsGenreFragment;
import com.zo0okadev.movieguide.ui.tvShows.tvShowsOnTheAir.TvShowsOnTheAirFragment;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {

    private TvShowsViewModel tvShowsViewModel;

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tv_shows, container, false);

        tvShowsViewModel = ViewModelProviders.of(this).get(TvShowsViewModel.class);

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
        Toolbar toolbar = rootView.findViewById(R.id.tv_shows_toolbar);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
    }

    private void initComponent(View rootView) {
        ViewPager view_pager = rootView.findViewById(R.id.tv_shows_view_pager);
        setupViewPager(view_pager);

        TabLayout tab_layout = rootView.findViewById(R.id.tv_shows_tab_layout);
        tab_layout.setupWithViewPager(view_pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());

        tvShowsViewModel.getTvShowGenres().observe(this, new Observer<List<Genre>>() {
            @Override
            public void onChanged(List<Genre> genres) {
                adapter.addFragment(TrendingTvShowsFragment.newInstance(), "TRENDING TV SHOWS");
                adapter.addFragment(TvShowsAiringTodayFragment.newInstance(), "TV SHOWS AIRING TODAY");
                adapter.addFragment(TvShowsOnTheAirFragment.newInstance(), "TV SHOWS ON THE AIR");

                for (Genre genre : genres) {
                    adapter.addFragment(TvShowsGenreFragment.newInstance(genre.getId()), genre.getName().toUpperCase());
                }

                viewPager.setAdapter(adapter);
            }
        });
    }
}
