package com.zo0okadev.movieguide.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.paging.PagedListAdapter;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.TrendingTvShow;
import com.zo0okadev.movieguide.ui.adapters.viewHolders.TrendingTvShowViewHolder;

public class TrendingTvShowsPagedListAdapter extends PagedListAdapter<TrendingTvShow, TrendingTvShowViewHolder> {

    private FragmentActivity activity;

    public TrendingTvShowsPagedListAdapter(FragmentActivity activity) {
        super(TrendingTvShow.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public TrendingTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrendingTvShowViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingTvShowViewHolder holder, int position) {
        holder.bindTo(getItem(position), activity);
    }
}
