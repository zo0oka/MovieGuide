package com.zo0okadev.movieguide.ui.movies.nowPlayingMovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class NowPlayingMoviesFragment extends Fragment {

    private NowPlayingMoviesViewModel mViewModel;

    public static NowPlayingMoviesFragment newInstance() {
        return new NowPlayingMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.now_playing_movies_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NowPlayingMoviesViewModel.class);
        // TODO: Use the ViewModel
    }

}
