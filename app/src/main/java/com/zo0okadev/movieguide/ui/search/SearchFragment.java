package com.zo0okadev.movieguide.ui.search;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.ui.SectionsPagerAdapter;
import com.zo0okadev.movieguide.ui.search.searchCelebs.SearchCelebsFragment;
import com.zo0okadev.movieguide.ui.search.searchMovies.SearchMoviesFragment;
import com.zo0okadev.movieguide.ui.search.searchTvShows.SearchTvShowsFragment;
import com.zo0okadev.movieguide.utils.Tools;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

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
        Toolbar toolbar = rootView.findViewById(R.id.search_toolbar);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Tools.setSystemBarColor(getActivity(), R.color.blue_600);
    }

    private void initComponent(View rootView) {
        ViewPager view_pager = rootView.findViewById(R.id.search_view_pager);
        setupViewPager(view_pager);

        TabLayout tab_layout = rootView.findViewById(R.id.search_tab_layout);
        tab_layout.setupWithViewPager(view_pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(SearchMoviesFragment.newInstance(), "MOVIES");
        adapter.addFragment(SearchTvShowsFragment.newInstance(), "TV SHOWS");
        adapter.addFragment(SearchCelebsFragment.newInstance(), "CELEBS");
        viewPager.setAdapter(adapter);
    }
}
