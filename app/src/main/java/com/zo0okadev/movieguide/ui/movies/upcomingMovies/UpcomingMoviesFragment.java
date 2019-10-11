package com.zo0okadev.movieguide.ui.movies.upcomingMovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zo0okadev.movieguide.R;

public class UpcomingMoviesFragment extends Fragment {

    private UpcomingMoviesViewModel mViewModel;

    public static UpcomingMoviesFragment newInstance() {
        return new UpcomingMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.upcoming_movies_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UpcomingMoviesViewModel.class);
        // TODO: Use the ViewModel
    }

}
