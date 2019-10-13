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

    @BindView(R.id.movie_thumbnail)
    ImageView movieThumbnail;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_user_rating)
    TextView movieUserRating;
    @BindView(R.id.movie_fav_icon)
    ImageView movieFavIcon;

    public ListMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindTo(ListMovie listMovie) {
        Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + listMovie.getPosterPath()).into(movieThumbnail);
        movieTitle.setText(listMovie.getTitle());
        movieUserRating.setText(String.valueOf(listMovie.getVoteAverage()));
    }
}
