package com.example.koincorountines.repository

import com.example.koincorountines.api.TmdbApi
import com.example.koincorountines.model.GetMoviesResponse

class MoviesRepository constructor(private val tmdbApi: TmdbApi) {

    suspend fun getPopularMovies(page: Int): GetMoviesResponse {
        return tmdbApi.getPopularMovies(page)
    }

    suspend fun getTopRatedMovies(page: Int): GetMoviesResponse {
        return tmdbApi.getTopRatedMovies(page)
    }

    suspend fun getUpcomingMovies(page: Int): GetMoviesResponse {
        return tmdbApi.getUpcomingMovies(page)
    }
}