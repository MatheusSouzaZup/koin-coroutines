package com.example.koincorountines

import android.app.Application
import com.example.koincorountines.di.netWorkModule
import com.example.koincorountines.di.repositoryModule
import com.example.koincorountines.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initKoin()
    }

    fun initKoin() {
        startKoin {
            androidContext(this@MoviesApplication)
            modules(listOf(viewModelModule, repositoryModule, netWorkModule))
        }
    }

    companion object {
        @get:Synchronized

        var instance: MoviesApplication? = null
            private set
    }
}