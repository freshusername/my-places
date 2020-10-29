package com.unrevealedinc.myplaces.ui

import android.app.Application
import timber.log.Timber

class MyPlacesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}