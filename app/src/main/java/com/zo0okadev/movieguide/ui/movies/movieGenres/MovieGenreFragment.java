package com.zo0okadev.movieguide.ui.movies.movieGenres;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.ui.adapters.MoviesPagedListAdapter;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MovieGenreFragment extends Fragment {

    private static final String TAG = MovieGenreFragment.class.getSimpleName();

    @BindView(R.id.genre_movies_recyclerView)
    RecyclerView genreMoviesRecyclerView;

    private MovieGenreViewModel mViewModel;
    private Unbinder unbinder;
    private MoviesPagedListAdapter adapter;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MovieGenreViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesPagedListAdapter(getActivity());
        genreMoviesRecyclerView.setHasFixedSize(true);
        genreMoviesRecyclerView.setAdapter(adapter);
        genreMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        int genreId = Objects.requireNonNull(getArguments()).getInt("genreId");
        Log.d(TAG, "onViewCreated: Genre ID: " + genreId);
        mViewModel.getGenreMovies(genreId).observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
