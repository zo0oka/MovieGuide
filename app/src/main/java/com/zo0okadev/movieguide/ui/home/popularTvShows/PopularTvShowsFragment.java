package com.zo0okadev.movieguide.ui.home.popularTvShows;

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
import com.zo0okadev.movieguide.ui.adapters.TvShowsPagedListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PopularTvShowsFragment extends Fragment {

    @BindView(R.id.popular_tv_shows_recyclerView)
    RecyclerView popularTvShowsRecyclerView;

    private PopularTvShowsViewModel mViewModel;
    private TvShowsPagedListAdapter adapter;
    private Unbinder unbinder;

    public static PopularTvShowsFragment newInstance() {
        return new PopularTvShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.popular_tv_shows_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PopularTvShowsViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TvShowsPagedListAdapter();
        popularTvShowsRecyclerView.setHasFixedSize(true);
        popularTvShowsRecyclerView.setAdapter(adapter);
        popularTvShowsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getPopularTvShows().observe(this, listTvShows -> adapter.submitList(listTvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
