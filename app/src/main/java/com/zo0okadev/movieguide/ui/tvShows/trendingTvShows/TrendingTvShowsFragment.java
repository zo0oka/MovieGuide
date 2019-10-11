package com.zo0okadev.movieguide.ui.tvShows.trendingTvShows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class TrendingTvShowsFragment extends Fragment {

    private TrendingTvShowsViewModel mViewModel;

    public static TrendingTvShowsFragment newInstance() {
        return new TrendingTvShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trending_tv_shows_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrendingTvShowsViewModel.class);
    }

}
