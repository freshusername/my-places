package com.unrevealedinc.myplaces.ui.app

import android.app.Application
import com.unrevealedinc.myplaces.ui.di.provideModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyPlacesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initServiceLocator()
    }

    private fun initServiceLocator() {
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MyPlacesApplication)
            modules(*provideModules())
        }
    }
}