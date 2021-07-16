package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.gayathri.preparation.R
import com.gayathri.preparation.components.CameraComponent
import com.gayathri.preparation.fragments.FragmentA
import com.gayathri.preparation.fragments.FragmentB
import kotlinx.android.synthetic.main.activity_h.*

class ActivityH : AppCompatActivity() {

    init {
        CameraComponent(this, ActivityH::class.java.simpleName)
    }

    // 1 create the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h)
        title = "Activity H"
        Log.d(ActivityH::class.java.name, "ActivityH onCreate")
        initUI()
    }

    private fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        btFragmentA.setOnClickListener {
            navController.apply {
//                navigate(R.id.fragmentA)
            }
            addFragment(FragmentA.newInstance("", ""), FragmentA::class.java.name)
        }
        btFragmentB.setOnClickListener {
//            navController.navigate(R.id.fragmentB)
            replaceFragment(FragmentB.newInstance("", ""), FragmentB::class.java.name)
        }
    }

    // without addToBackStack(TAG) there is no back button navigation skips the
    // fragment and directly goes back the next previous one with back stack available or to the activity
    // https://stackoverflow.com/questions/18634207/difference-between-add-replace-and-addtobackstack
    private fun addFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, fragment)
            .addToBackStack(name)
            .commit()
    }

    private fun replaceFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, fragment)
            .addToBackStack(name)
            .commit()
    }

    // 2 Visible to the user
    override fun onStart() {
        super.onStart()
        Log.d(ActivityH::class.java.name, "ActivityH onStart")
    }

    /**
     * The onStart() and onResume() will be called in quick succession
     */

    // 3 Becomes interactive with the user
    /**
     * The app stays in this state until something happens to take focus away from the app.
     * Such an event might be, for instance, receiving a phone call
     * The user's navigating to another activity, or
     * The device screen's turning off
     * App goes to background and comes back to foreground
     * Switching between apps in the background to foreground
     */
    override fun onResume() {
        super.onResume()
        Log.d(ActivityH::class.java.name, "ActivityH onResume")
    }

    // 4 first indication that the user is leaving your activity
    override fun onPause() {
        super.onPause()
        Log.d(ActivityH::class.java.name, "ActivityH onPause")
    }

    // 5 No longer visible to the user
    override fun onStop() {
        super.onStop()
        Log.d(ActivityH::class.java.name, "ActivityH onStop")
    }

    // comes into picture when app shows up in foreground from the stop state
    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityH::class.java.name, "ActivityH onRestart")
    }

    // 6 called before the activity us destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityH::class.java.name, "ActivityH onDestroy")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        Log.d("preparation_log", "ActivityH intent $intent")
    }

}