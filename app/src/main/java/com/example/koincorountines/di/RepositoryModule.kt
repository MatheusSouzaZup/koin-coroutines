package com.example.koincorountines.di

import com.example.koincorountines.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MoviesRepository(tmdbApi = get()) }
}
