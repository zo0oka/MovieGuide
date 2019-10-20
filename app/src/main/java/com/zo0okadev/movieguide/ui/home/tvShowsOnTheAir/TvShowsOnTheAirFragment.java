package com.zo0okadev.movieguide.ui.home.tvShowsOnTheAir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class TvShowsOnTheAirFragment extends Fragment {

    private TvShowsOnTheAirViewModel mViewModel;

    public static TvShowsOnTheAirFragment newInstance() {
        return new TvShowsOnTheAirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_shows_on_the_air_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TvShowsOnTheAirViewModel.class);
    }

}
