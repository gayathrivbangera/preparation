package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log

class ActivityA : BaseActivity() {

    private var launchModeHere: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity A"
        Log.d("preparation_log", "onCreate of A ")
        setLaunchMode("Standard")

        //        onSaveInstanceState(Bundle().apply {
//            putString("launch_mode", mode)
//        })

        /*if (savedInstanceState != null) {
            launchModeHere = savedInstanceState.getString("launch_mode").orEmpty()
            Log.d("preparation_log", "if base $launchModeHere")
        } else {
            launchModeHere = "none"
            Log.d("preparation_log", "else base $launchModeHere")
        }*/
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        Log.d("preparation_log", "ActivityA intent $intent")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        Log.d("preparation_log", "onRestoreInstanceState $savedInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("launch_mode", launchModeHere)
        super.onSaveInstanceState(outState)
//        Log.d("preparation_log", "onSaveInstanceState $outState")
    }

    override fun onResume() {
        super.onResume()
        Log.d("preparation_log", "onResume of A $launchModeHere")
    }

    override fun onStart() {
        super.onStart()
        Log.d("preparation_log", "onStart of A ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("preparation_log", "onStop of A ")
    }
}