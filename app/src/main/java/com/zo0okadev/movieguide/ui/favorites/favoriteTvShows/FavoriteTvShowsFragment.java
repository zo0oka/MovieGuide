package com.zo0okadev.movieguide.ui.favorites.favoriteTvShows;

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

public class FavoriteTvShowsFragment extends Fragment {

    @BindView(R.id.favorite_tv_shows_recyclerView)
    RecyclerView favoriteTvShowsRecyclerView;

    private FavoriteTvShowsViewModel mViewModel;
    private Unbinder unbinder;
    private TvShowsPagedListAdapter adapter;

    public static FavoriteTvShowsFragment newInstance() {
        return new FavoriteTvShowsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_tv_shows_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FavoriteTvShowsViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TvShowsPagedListAdapter(getActivity());
        favoriteTvShowsRecyclerView.setHasFixedSize(true);
        favoriteTvShowsRecyclerView.setAdapter(adapter);
        favoriteTvShowsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getFavoriteTvShows().observe(this, listTvShows -> adapter.submitList(listTvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
