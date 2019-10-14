package com.zo0okadev.movieguide.ui.tvShows.tvShowsGenres;

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

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TvShowsGenreFragment extends Fragment {

    @BindView(R.id.genre_tv_shows_recyclerView)
    RecyclerView genreTvShowsRecyclerView;

    private TvShowsGenreViewModel mViewModel;
    private Unbinder unbinder;
    private TvShowsPagedListAdapter adapter;

    public static TvShowsGenreFragment newInstance(int genreId) {
        TvShowsGenreFragment fragment = new TvShowsGenreFragment();
        Bundle args = new Bundle();
        args.putInt("genreId", genreId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_shows_genres_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TvShowsGenreViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new TvShowsPagedListAdapter(getActivity());
        genreTvShowsRecyclerView.setHasFixedSize(true);
        genreTvShowsRecyclerView.setAdapter(adapter);
        genreTvShowsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        int genreId = Objects.requireNonNull(getArguments()).getInt("genreId");
        mViewModel.getGenreTvShows(genreId).observe(this, listTvShows -> adapter.submitList(listTvShows));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
