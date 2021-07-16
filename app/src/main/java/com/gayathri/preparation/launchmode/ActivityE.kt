package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.gayathri.preparation.databinding.ActivityEBinding

class ActivityE : BaseActivity() {
    private lateinit var binding: ActivityEBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityEBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        initUii()

        title = "Activity E"
    }

    fun initUii() {

        binding.myTabLayout.setUpTab { tab ->
            startActivity(Intent(this, tab.target))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("preparation_log", "ActivityE intent $intent")
    }
}