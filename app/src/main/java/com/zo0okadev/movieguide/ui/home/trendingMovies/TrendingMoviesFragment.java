package com.zo0okadev.movieguide.ui.home.trendingMovies;

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
import com.zo0okadev.movieguide.ui.adapters.TrendingMoviesPagedListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TrendingMoviesFragment extends Fragment {

    @BindView(R.id.trending_movies_recyclerView)
    RecyclerView trendingMoviesRecyclerView;

    private TrendingMoviesViewModel mViewModel;
    private TrendingMoviesPagedListAdapter adapter;
    private Unbinder unbinder;

    public static TrendingMoviesFragment newInstance() {
        return new TrendingMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trending_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrendingMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TrendingMoviesPagedListAdapter(getActivity());
        trendingMoviesRecyclerView.setHasFixedSize(true);
        trendingMoviesRecyclerView.setAdapter(adapter);
        trendingMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getTrendingMovies().observe(this, listTrendingMovies -> adapter.submitList(listTrendingMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
