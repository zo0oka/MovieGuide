package com.zo0okadev.movieguide.ui.home.nowPlayingMovies;

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

public class NowPlayingMoviesFragment extends Fragment {

    @BindView(R.id.now_playing_movies_recyclerView)
    RecyclerView nowPlayingMoviesRecyclerView;

    private NowPlayingMoviesViewModel mViewModel;
    private MoviesPagedListAdapter adapter;
    private Unbinder unbinder;

    public static NowPlayingMoviesFragment newInstance() {
        return new NowPlayingMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.now_playing_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NowPlayingMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesPagedListAdapter(getActivity());
        nowPlayingMoviesRecyclerView.setHasFixedSize(true);
        nowPlayingMoviesRecyclerView.setAdapter(adapter);
        nowPlayingMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getNowPlayingMovies().observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
