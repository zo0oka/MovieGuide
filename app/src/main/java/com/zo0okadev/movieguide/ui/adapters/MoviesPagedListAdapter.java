package com.zo0okadev.movieguide.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.ui.adapters.viewHolders.ListMovieViewHolder;

import java.util.Objects;

import static com.zo0okadev.movieguide.model.ListMovie.DIFF_CALLBACK;

public class MoviesPagedListAdapter extends androidx.paging.PagedListAdapter<ListMovie, ListMovieViewHolder> {

    public MoviesPagedListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ListMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListMovieViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_card,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieViewHolder holder, int position) {
        holder.bindTo(Objects.requireNonNull(getItem(position)));
    }
}