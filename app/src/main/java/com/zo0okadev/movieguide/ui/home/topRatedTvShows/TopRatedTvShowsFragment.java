package com.zo0okadev.movieguide.ui.home.topRatedTvShows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.ui.adapters.MoviesPagedListAdapter;
import com.zo0okadev.movieguide.ui.adapters.TvShowsPagedListAdapter;
import com.zo0okadev.movieguide.ui.home.topRatedMovies.TopRatedMoviesFragment;
import com.zo0okadev.movieguide.ui.home.topRatedMovies.TopRatedMoviesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TopRatedTvShowsFragment extends Fragment {

    @BindView(R.id.top_rated_tv_shows_recyclerView)
    RecyclerView topRatedTvShowsRecyclerView;

    private TopRatedTvShowsViewModel mViewModel;
    private TvShowsPagedListAdapter adapter;
    private Unbinder unbinder;

    public static TopRatedTvShowsFragment newInstance() {
        return new TopRatedTvShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.top_rated_tv_shows_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TopRatedTvShowsViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TvShowsPagedListAdapter();
        topRatedTvShowsRecyclerView.setHasFixedSize(true);
        topRatedTvShowsRecyclerView.setAdapter(adapter);
        topRatedTvShowsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getTopRatedTvShows().observe(this, listTvShows -> adapter.submitList(listTvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
