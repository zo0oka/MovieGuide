package com.zo0okadev.movieguide.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.paging.PagedListAdapter;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.TrendingMovie;
import com.zo0okadev.movieguide.ui.adapters.viewHolders.TrendingMovieViewHolder;


public class TrendingMoviesPagedListAdapter extends PagedListAdapter<TrendingMovie, TrendingMovieViewHolder> {

    private FragmentActivity activity;

    public TrendingMoviesPagedListAdapter(FragmentActivity activity) {
        super(TrendingMovie.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public TrendingMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrendingMovieViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMovieViewHolder holder, int position) {
        holder.bindTo(getItem(position), activity);
    }
}
