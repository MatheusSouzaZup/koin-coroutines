package com.example.koincorountines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.koincorountines.R
import com.example.koincorountines.model.MoviesPresentation
import com.example.koincorountines.repository.MoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel constructor(private val moviesRepository: MoviesRepository) :
    BaseViewModel() {

    val screen = MutableLiveData<Screen>()

    fun getMovies() {
        viewModelScope.launch {
            runCatching {
                val popularResult = moviesRepository.getPopularMovies(1)
                val topRatedResult = moviesRepository.getTopRatedMovies(1)
                val upcomingResult = moviesRepository.getUpcomingMovies(1)

                screen.postValue(
                    Screen.ShowData(
                        MoviesPresentation(
                            popularResult.movies,
                            topRatedResult.movies,
                            upcomingResult.movies
                        )
                    )
                )
            }.onFailure {
                screen.postValue(Screen.ShowError(R.string.base_error))
            }
        }
    }

    sealed class Screen {
        data class ShowData(val moviesPresentation: MoviesPresentation) : Screen()
        object ShowLoading : Screen()
        object HideLoading : Screen()
        data class ShowError(val error: Int) : Screen()
    }
}