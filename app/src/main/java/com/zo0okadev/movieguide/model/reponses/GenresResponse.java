package com.zo0okadev.movieguide.model.reponses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zo0okadev.movieguide.model.Genre;

import java.util.List;

public class GenresResponse {

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}
