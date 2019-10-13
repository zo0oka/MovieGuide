package com.zo0okadev.movieguide.ui.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListMovie;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zo0okadev.movieguide.utils.Constants.IMAGE_BASE_URL;
import static com.zo0okadev.movieguide.utils.Constants.LIST_MOVIE_POSTER_WIDTH;

public class ListMovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_thumbnail)
    ImageView itemThumbnail;
    @BindView(R.id.item_title)
    TextView itemTitle;
    @BindView(R.id.item_user_rating)
    TextView itemUserRating;
    @BindView(R.id.item_fav_icon)
    ImageView itemFavIcon;

    public ListMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindTo(ListMovie listMovie) {
        if (listMovie.getPosterPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + listMovie.getPosterPath()).into(itemThumbnail);
        } else if (listMovie.getBackdropPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + listMovie.getBackdropPath()).into(itemThumbnail);
        } else {
            itemThumbnail.setImageResource(R.drawable.ic_movies_fallback);
            itemThumbnail.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }        itemTitle.setText(listMovie.getTitle());
        itemUserRating.setText(String.valueOf(listMovie.getVoteAverage()));
    }
}
