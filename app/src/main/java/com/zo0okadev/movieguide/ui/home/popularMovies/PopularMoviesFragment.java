package com.zo0okadev.movieguide.ui.home.popularMovies;

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

public class PopularMoviesFragment extends Fragment {

    @BindView(R.id.popular_movies_recyclerView)
    RecyclerView popularMoviesRecyclerView;

    private PopularMoviesViewModel mViewModel;
    private MoviesPagedListAdapter adapter;
    private Unbinder unbinder;

    public static PopularMoviesFragment newInstance() {
        return new PopularMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.popular_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesPagedListAdapter(getActivity());
        popularMoviesRecyclerView.setHasFixedSize(true);
        popularMoviesRecyclerView.setAdapter(adapter);
        popularMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getPopularMovies().observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
