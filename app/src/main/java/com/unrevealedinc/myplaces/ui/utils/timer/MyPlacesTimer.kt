package com.unrevealedinc.myplaces.ui.utils.timer

import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

open class MyPlacesTimer(lifecycle: Lifecycle) : LifecycleObserver {
    var secondsCount = 0

    var handler = Handler()
    lateinit var runnable: Runnable

    init {
        lifecycle.addObserver(this)
    }
}