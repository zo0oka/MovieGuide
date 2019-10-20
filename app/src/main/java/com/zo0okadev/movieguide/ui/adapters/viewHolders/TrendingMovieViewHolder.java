package com.zo0okadev.movieguide.ui.adapters.viewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zo0okadev.movieguide.R;
import com.zo0okadev.movieguide.model.ListMovie;
import com.zo0okadev.movieguide.model.TrendingMovie;
import com.zo0okadev.movieguide.ui.favorites.favoriteMovies.FavoriteMoviesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zo0okadev.movieguide.utils.Constants.IMAGE_BASE_URL;
import static com.zo0okadev.movieguide.utils.Constants.LIST_MOVIE_POSTER_WIDTH;

public class TrendingMovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_thumbnail)
    ImageView itemThumbnail;
    @BindView(R.id.item_title)
    TextView itemTitle;
    @BindView(R.id.item_user_rating)
    TextView itemUserRating;
    @BindView(R.id.item_fav_icon)
    ImageView itemFavIcon;

    public TrendingMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindTo(TrendingMovie trendingMovie, FragmentActivity activity) {

        FavoriteMoviesViewModel viewModel = ViewModelProviders.of(activity).get(FavoriteMoviesViewModel.class);

        viewModel.isFavorite(trendingMovie.getId()).observe(activity, listMovies -> {
            Log.d("Favorites", "Favorites: " + listMovies.size());
            if (listMovies.size() > 0) {
                Log.d("Favorites", "Index of movie: " + listMovies.indexOf(trendingMovie));
                Log.d("Favorites", trendingMovie.getTitle() + " is bookmarked!");
                itemFavIcon.setImageResource(R.drawable.ic_favorite);
                itemFavIcon.setTag("bookmarked");
            } else {
                itemFavIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                itemFavIcon.setTag("not_bookmarked");
            }
        });

        itemFavIcon.setOnClickListener(v -> {
            if (itemFavIcon.getTag().equals("bookmarked")) {
                viewModel.deleteFavoriteMovie(trendingMovie.getId());
                itemFavIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                itemFavIcon.setTag("not_bookmarked");
            } else if (itemFavIcon.getTag().equals("not_bookmarked")) {
                viewModel.insertFavoriteMovie(new ListMovie(
                                trendingMovie.getPopularity(),
                                trendingMovie.getVoteCount(),
                                trendingMovie.getVideo(),
                                trendingMovie.getPosterPath(),
                                trendingMovie.getId(),
                                trendingMovie.getAdult(),
                                trendingMovie.getBackdropPath(),
                                trendingMovie.getOriginalLanguage(),
                                trendingMovie.getOriginalTitle(),
                                trendingMovie.getGenreIds(),
                                trendingMovie.getTitle(),
                                trendingMovie.getVoteAverage(),
                                trendingMovie.getOverview(),
                                trendingMovie.getReleaseDate()));
                itemFavIcon.setImageResource(R.drawable.ic_favorite);
                itemFavIcon.setTag("bookmarked");
            }
        });

        if (trendingMovie.getPosterPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + trendingMovie.getPosterPath()).into(itemThumbnail);
        } else if (trendingMovie.getBackdropPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + trendingMovie.getBackdropPath()).into(itemThumbnail);
        } else {
            itemThumbnail.setImageResource(R.drawable.ic_movies_fallback);
            itemThumbnail.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }        itemTitle.setText(trendingMovie.getTitle());
        itemUserRating.setText(String.valueOf(trendingMovie.getVoteAverage()));
    }
}
