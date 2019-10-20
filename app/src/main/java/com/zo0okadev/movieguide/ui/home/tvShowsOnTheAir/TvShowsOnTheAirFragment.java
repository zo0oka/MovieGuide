package com.zo0okadev.movieguide.ui.home.tvShowsOnTheAir;

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

public class TvShowsOnTheAirFragment extends Fragment {

    @BindView(R.id.tv_shows_on_the_air_recyclerView)
    RecyclerView tvShowsOnTheAirRecyclerView;

    private TvShowsOnTheAirViewModel mViewModel;
    private TvShowsPagedListAdapter adapter;
    private Unbinder unbinder;

    public static TvShowsOnTheAirFragment newInstance() {
        return new TvShowsOnTheAirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_shows_on_the_air_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TvShowsOnTheAirViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TvShowsPagedListAdapter(getActivity());
        tvShowsOnTheAirRecyclerView.setHasFixedSize(true);
        tvShowsOnTheAirRecyclerView.setAdapter(adapter);
        tvShowsOnTheAirRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getTvShowsOnTheAir().observe(this, tvShows -> adapter.submitList(tvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
