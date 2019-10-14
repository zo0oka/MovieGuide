package com.zo0okadev.movieguide.ui.favorites.favoriteMovies;

import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FavoriteMoviesFragment extends Fragment {

    @BindView(R.id.favorite_movies_recyclerView)
    RecyclerView favoriteMoviesRecyclerView;

    private FavoriteMoviesViewModel mViewModel;
    private Unbinder unbinder;
    private MoviesPagedListAdapter adapter;

    public static FavoriteMoviesFragment newInstance() {
        return new FavoriteMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FavoriteMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesPagedListAdapter(getActivity());
        favoriteMoviesRecyclerView.setHasFixedSize(true);
        favoriteMoviesRecyclerView.setAdapter(adapter);
        favoriteMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getFavoriteMovies().observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
