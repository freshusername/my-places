package com.unrevealedinc.myplaces.ui.utils.timer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class DestroyTimer (lifecycle: Lifecycle): MyPlacesTimer(lifecycle) {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer(){
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer (Active) in sec : $secondsCount")
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopTimer(){
        handler.removeCallbacks(runnable)
    }
}