package com.gayathri.preparation.launchmode

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gayathri.preparation.MainActivity
import com.gayathri.preparation.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tab_layout.view.*

class MyTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(
            R.layout.tab_layout, this
        )
    }

    fun setUpTab(onTabClick: (tab: TabElement) -> Unit) {
        tabLayout?.run {
            for (tab in getTabs) {
                addTab(newTab().setText("Activity ${tab.name}"))
            }
            clearOnTabSelectedListeners()
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    onTabClick(getTabs[tab?.position ?: 0])
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })
        }
    }
}


val getTabs = listOf(
    TabElement("Main", MainActivity::class.java, "Standard"),
    TabElement("A", ActivityA::class.java, "Standard"),
    TabElement("B", ActivityB::class.java, "SingleTask"),
    TabElement("C", ActivityC::class.java, "SingleTop"),
    TabElement("D", ActivityD::class.java, "SingleTask"),
    TabElement("E", ActivityE::class.java, "Standard"),
    TabElement("F", ActivityF::class.java, "Standard"),
    TabElement("G", ActivityG::class.java, "Single Instance"),
    TabElement("H", ActivityH::class.java, "Standard"),
    TabElement("Main", MainActivity::class.java, "Standard"),
    TabElement("A", ActivityA::class.java, "Standard"),
    TabElement("B", ActivityB::class.java, "SingleTask"),
    TabElement("C", ActivityC::class.java, "SingleTop"),
    TabElement("D", ActivityD::class.java, "SingleTask"),
    TabElement("E", ActivityE::class.java, "Standard"),
    TabElement("F", ActivityF::class.java, "Standard"),
    TabElement("G", ActivityG::class.java, "Single Instance"),
    TabElement("H", ActivityH::class.java, "Standard")
)

data class TabElement(
    val name: String,
    val target: Class<out Activity>,
    val launchMode: String
)