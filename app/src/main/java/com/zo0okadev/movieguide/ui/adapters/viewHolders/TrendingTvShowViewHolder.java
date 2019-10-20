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
import com.zo0okadev.movieguide.model.ListTvShow;
import com.zo0okadev.movieguide.model.TrendingTvShow;
import com.zo0okadev.movieguide.ui.favorites.favoriteTvShows.FavoriteTvShowsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zo0okadev.movieguide.utils.Constants.IMAGE_BASE_URL;
import static com.zo0okadev.movieguide.utils.Constants.LIST_MOVIE_POSTER_WIDTH;

public class TrendingTvShowViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_thumbnail)
    ImageView itemThumbnail;
    @BindView(R.id.item_title)
    TextView itemTitle;
    @BindView(R.id.item_user_rating)
    TextView itemUserRating;
    @BindView(R.id.item_fav_icon)
    ImageView itemFavIcon;

    public TrendingTvShowViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindTo(TrendingTvShow trendingTvShow, FragmentActivity activity) {

        FavoriteTvShowsViewModel viewModel = ViewModelProviders.of(activity).get(FavoriteTvShowsViewModel.class);

        viewModel.isFavorite(trendingTvShow.getId()).observe(activity, listMovies -> {
            Log.d("Favorites", "Favorites: " + listMovies.size());
            if (listMovies.size() > 0) {
                Log.d("Favorites", trendingTvShow.getName() + " is bookmarked!");
                itemFavIcon.setImageResource(R.drawable.ic_favorite);
                itemFavIcon.setTag("bookmarked");
            } else {
                itemFavIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                itemFavIcon.setTag("not_bookmarked");
            }
        });

        itemFavIcon.setOnClickListener(v -> {
            if (itemFavIcon.getTag().equals("bookmarked")) {
                viewModel.deleteFavoriteTvShow(trendingTvShow.getId());
                itemFavIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                itemFavIcon.setTag("not_bookmarked");
            } else if (itemFavIcon.getTag().equals("not_bookmarked")) {
                viewModel.insertFavoriteTvShow(new ListTvShow(
                        trendingTvShow.getOriginalName(),
                        trendingTvShow.getGenreIds(),
                        trendingTvShow.getName(),
                        trendingTvShow.getPopularity(),
                        trendingTvShow.getOriginCountry(),
                        trendingTvShow.getVoteCount(),
                        trendingTvShow.getFirstAirDate(),
                        trendingTvShow.getBackdropPath(),
                        trendingTvShow.getOriginalLanguage(),
                        trendingTvShow.getId(),
                        trendingTvShow.getVoteAverage(),
                        trendingTvShow.getOverview(),
                        trendingTvShow.getPosterPath()));
                itemFavIcon.setImageResource(R.drawable.ic_favorite);
                itemFavIcon.setTag("bookmarked");
            }
        });

        if (trendingTvShow.getPosterPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + trendingTvShow.getPosterPath()).into(itemThumbnail);
        } else if (trendingTvShow.getBackdropPath() != null) {
            Glide.with(itemView).load(IMAGE_BASE_URL + LIST_MOVIE_POSTER_WIDTH + trendingTvShow.getBackdropPath()).into(itemThumbnail);
        } else {
            itemThumbnail.setImageResource(R.drawable.ic_tv_shw_fallback);
            itemThumbnail.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        itemTitle.setText(trendingTvShow.getName());
        itemUserRating.setText(String.valueOf(trendingTvShow.getVoteAverage()));
    }
}
