package com.zo0okadev.movieguide.ui.home.topRatedMovies;

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
import com.zo0okadev.movieguide.ui.adapters.ListMoviesPagedAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TopRatedMoviesFragment extends Fragment {

    @BindView(R.id.top_rated_movies_recyclerView)
    RecyclerView topRatedMoviesRecyclerView;

    private TopRatedMoviesViewModel mViewModel;
    private ListMoviesPagedAdapter adapter;
    private Unbinder unbinder;

    public static TopRatedMoviesFragment newInstance() {
        return new TopRatedMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.top_rated_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TopRatedMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new ListMoviesPagedAdapter();
        topRatedMoviesRecyclerView.setHasFixedSize(true);
        topRatedMoviesRecyclerView.setAdapter(adapter);
        topRatedMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getTopRatedMovies().observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
