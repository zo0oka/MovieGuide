package com.zo0okadev.movieguide.ui.home.trendingTvShows;

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
import com.zo0okadev.movieguide.ui.adapters.TrendingTvShowsPagedListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TrendingTvShowsFragment extends Fragment {

    @BindView(R.id.trending_Tv_shows_recyclerView)
    RecyclerView trendingTvShowsRecyclerView;

    private TrendingTvShowsViewModel mViewModel;
    private TrendingTvShowsPagedListAdapter adapter;
    private Unbinder unbinder;

    public static TrendingTvShowsFragment newInstance() {
        return new TrendingTvShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trending_tv_shows_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TrendingTvShowsViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TrendingTvShowsPagedListAdapter(getActivity());
        trendingTvShowsRecyclerView.setHasFixedSize(true);
        trendingTvShowsRecyclerView.setAdapter(adapter);
        trendingTvShowsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getTrendingTvShows().observe(this, trendingTvShows -> adapter.submitList(trendingTvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
