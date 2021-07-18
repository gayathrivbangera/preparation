package com.gayathri.preparation.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gayathri.preparation.R

class TabsAdapter(private val data: List<String> = emptyList()) :
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

        fun setData(tabElement: String) {
            name.apply {
                setOnClickListener {
//                    startActivity(context, Intent(context, tabElement.target), null)
                }
            }
        }
    }
}