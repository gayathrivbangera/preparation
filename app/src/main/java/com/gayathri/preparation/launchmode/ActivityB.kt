package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log

class ActivityB : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity B"
        setLaunchMode("SingleTask")
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("preparation_log", "ActivityB intent $intent")
    }
}