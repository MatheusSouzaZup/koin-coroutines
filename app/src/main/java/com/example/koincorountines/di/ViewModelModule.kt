package com.example.koincorountines.di

import com.example.koincorountines.viewmodel.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesViewModel(moviesRepository = get()) }
}
