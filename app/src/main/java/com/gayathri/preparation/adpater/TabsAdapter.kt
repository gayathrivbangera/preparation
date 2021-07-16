package com.gayathri.preparation.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.gayathri.preparation.R
import com.gayathri.preparation.launchmode.TabElement

class TabsAdapter(private val data: List<TabElement> = emptyList()) :
    RecyclerView.Adapter<TabsAdapter.TabsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_tabs_view, parent, false)
        return TabsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TabsViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int = data.size

    class TabsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var name: TextView = view.findViewById(R.id.tvName)

        fun setData(tabElement: TabElement) {
            name.apply {
//                append("Activity")
//                append(" ")
//                append(tabElement.name)
                text = "Activity ${tabElement.name} \n ${tabElement.launchMode}"
                setOnClickListener {
                    startActivity(context, Intent(context, tabElement.target), null)
                }
            }
        }
    }
}