package com.zo0okadev.movieguide.ui.home.TvShowsAiringToday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class TvShowsAiringTodayFragment extends Fragment {

    private TvShowsAiringTodayViewModel mViewModel;

    public static TvShowsAiringTodayFragment newInstance() {
        return new TvShowsAiringTodayFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_shows_airing_today_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TvShowsAiringTodayViewModel.class);
    }

}
