package com.gayathri.preparation.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.gayathri.preparation.BaseViewModel
import com.gayathri.preparation.adpater.TabsAdapter
import com.gayathri.preparation.databinding.ActivityBaseBinding
import kotlinx.android.synthetic.main.activity_base.*

open class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    private val viewModel = ViewModelProvider.NewInstanceFactory().create(BaseViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUi()
        title = "Base Activity"
        binding.viewmodel = viewModel
        Log.d(BaseActivity::class.java.name, "ActivityBase onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(BaseActivity::class.java.name, "ActivityBase onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(BaseActivity::class.java.name, "ActivityBase onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(BaseActivity::class.java.name, "ActivityBase onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(BaseActivity::class.java.name, "ActivityBase onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(BaseActivity::class.java.name, "ActivityBase onRestart")
    }

    open fun initUi() {
        myTabLayout?.setUpTab { tab ->
            startActivity(Intent(this, tab.target))
        }
        setLaunchMode()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.tabElementsLiveData.observe(this, { tabs ->
            binding.recyclerView.adapter = TabsAdapter(tabs)
        })
    }

    @BindingAdapter("app:goneUnless")
    fun goneUnless(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    open fun setLaunchMode(mode: String = "Standard") {
        binding.launchMode = mode
    }
}
