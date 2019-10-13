package com.zo0okadev.movieguide.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.ui.adapters.viewHolders.ListMovieViewHolder;

import java.util.Objects;

public class ListMoviesPagedAdapter extends PagedListAdapter<ListMovie, ListMovieViewHolder> {

    public ListMoviesPagedAdapter() {
        super(ListMovie.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ListMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListMovieViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_movie_card,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieViewHolder holder, int position) {
        holder.bindTo(Objects.requireNonNull(getItem(position)));
    }
}
