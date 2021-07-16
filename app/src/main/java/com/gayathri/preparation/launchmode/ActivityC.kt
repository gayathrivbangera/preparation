package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log

class ActivityC : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity C"
        setLaunchMode("Single Top")
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("preparation_log", "ActivityC intent $intent")
    }
}