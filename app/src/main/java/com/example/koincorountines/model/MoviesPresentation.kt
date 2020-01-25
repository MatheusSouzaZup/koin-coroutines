package com.example.koincorountines.model

data class MoviesPresentation(
    val populars: List<Movie>,
    val topRated: List<Movie>,
    val upComing: List<Movie>
)
