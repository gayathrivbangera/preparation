package com.gayathri.preparation.components

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class CameraComponent(private val lifecycleOwner: LifecycleOwner, private val activity: String) :
    LifecycleObserver {
    init {
        Log.d(
            "preparation_log",
            "init CameraComponent ${lifecycleOwner.lifecycle.currentState} $activity"
        )
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("preparation_log", "release Camera on Pause $activity")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("preparation_log", "release Camera on Pause $activity")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d("preparation_log", "start Camera on Resume $activity")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        Log.d("preparation_log", "onDestory $activity ")
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}
