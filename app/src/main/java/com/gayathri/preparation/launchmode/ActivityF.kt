package com.gayathri.preparation.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gayathri.preparation.R
import com.gayathri.preparation.components.CameraComponent

class ActivityF : BaseActivity() {

    init {
       // CameraComponent(this, ActivityF::class.java.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity F"
        val state = savedInstanceState?.getString("state")
        Log.d(ActivityF::class.java.name, "ActivityF onCreate state $state")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityF::class.java.name, "ActivityF onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityF::class.java.name, "ActivityF onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityF::class.java.name, "ActivityF onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityF::class.java.name, "ActivityF onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityF::class.java.name, "ActivityF onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityF::class.java.name, "ActivityF onDestroy")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        Log.d("preparation_log", "ActivityF intent $intent")
    }

    /**
     * Please notice that onRestoreInstanceState() is called when activity is recreated but only if:
     * It was killed by the OS. "Such situation happen when:
     * 1. Orientation of the deice changes (your activity us destroyed and recreated)
     * 2. There is another activity in front of yours and at some point the OS kills your activity
     *    in order to free memory (for example). Next time when you start your activity
     *    onRestoreInstanceState() will be called.
     *
     *    So if you are in your activity and you hit Back button on the device,
     *    your activity is finish()ed and next time you start your app it is started again (it sounds like re-created,
     *    isn't it?) but this time without saved state because you intentionally exited it when you hit Back button.
     *    https://stackoverflow.com/questions/12793069/android-onsaveinstancestate-not-being-called-from-activity
     */
    // called after onStart()
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val state_text = savedInstanceState.getString("state_text")
        Log.d(
            "preparation_log",
            "ActivityF onRestoreInstanceState state_text $state_text"
        )
    }

    // called after onStop()
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("preparation_log", "ActivityF onSaveInstanceState")
        outState.run {
            putString("state", "already created")
            putString("state_text", "have seen this activity before")
        }
        super.onSaveInstanceState(outState)
    }
}