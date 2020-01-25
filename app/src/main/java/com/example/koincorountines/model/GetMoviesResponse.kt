package com.example.koincorountines.model

import com.example.koincorountines.model.Movie
import com.google.gson.annotations.SerializedName

class GetMoviesResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)