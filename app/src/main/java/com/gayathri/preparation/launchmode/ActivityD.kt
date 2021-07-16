package com.gayathri.preparation.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gayathri.preparation.R
import kotlinx.android.synthetic.main.activity_main.*

class ActivityD : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity D"
        setLaunchMode("SingleTask")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("preparation_log", "ActivityD intent $intent")
    }
}