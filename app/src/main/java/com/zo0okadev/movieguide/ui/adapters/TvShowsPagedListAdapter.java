package com.zo0okadev.movieguide.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.paging.PagedListAdapter;

import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.ui.adapters.viewHolders.ListTvShowViewHolder;

import java.util.Objects;

import static com.zo0okadev.movieguide.model.ListTvShow.DIFF_CALLBACK;

public class TvShowsPagedListAdapter extends PagedListAdapter<ListTvShow, ListTvShowViewHolder> {

    private FragmentActivity activity;

    public TvShowsPagedListAdapter(FragmentActivity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListTvShowViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListTvShowViewHolder holder, int position) {
        holder.bindTo(Objects.requireNonNull(getItem(position)), activity);
    }
}
