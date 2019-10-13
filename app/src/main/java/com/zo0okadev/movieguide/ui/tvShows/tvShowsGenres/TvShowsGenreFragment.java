package com.zo0okadev.movieguide.ui.tvShows.tvShowsGenres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class TvShowsGenreFragment extends Fragment {

    private TvShowsGenreViewModel mViewModel;

    public static TvShowsGenreFragment newInstance(int genreId) {
        TvShowsGenreFragment fragment = new TvShowsGenreFragment();
        Bundle args = new Bundle();
        args.putInt("genreId", genreId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_shows_genres_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TvShowsGenreViewModel.class);
    }

}
