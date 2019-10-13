package com.zo0okadev.movieguide.ui.movies.movieGenres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class MovieGenreFragment extends Fragment {

    private MovieGenreViewModel mViewModel;

    public static MovieGenreFragment newInstance(int genreId) {
        MovieGenreFragment fragment = new MovieGenreFragment();
        Bundle args = new Bundle();
        args.putInt("genreId", genreId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_genres_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MovieGenreViewModel.class);
    }

}
