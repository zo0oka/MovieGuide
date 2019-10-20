package com.zo0okadev.movieguide.ui.home.upcomingMovies;

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

public class UpcomingMoviesFragment extends Fragment {

    @BindView(R.id.upcoming_movies_recyclerView)
    RecyclerView upcomingMoviesRecyclerView;

    private UpcomingMoviesViewModel mViewModel;
    private MoviesPagedListAdapter adapter;
    private Unbinder unbinder;

    public static UpcomingMoviesFragment newInstance() {
        return new UpcomingMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.upcoming_movies_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UpcomingMoviesViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        adapter = new MoviesPagedListAdapter(getActivity());
        upcomingMoviesRecyclerView.setHasFixedSize(true);
        upcomingMoviesRecyclerView.setAdapter(adapter);
        upcomingMoviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mViewModel.getUpcomingMovies().observe(this, listMovies -> adapter.submitList(listMovies));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

