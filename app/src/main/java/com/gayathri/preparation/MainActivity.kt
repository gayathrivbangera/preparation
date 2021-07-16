package com.gayathri.preparation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gayathri.preparation.launchmode.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        startActivity(Intent(this, BaseActivity::class.java))
        myTabLayout?.setUpTab { tab ->
            startActivity(Intent(this, tab.target))
        }
    }
}
