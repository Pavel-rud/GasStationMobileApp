package com.example.gasstationmobileapp.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gasstationmobileapp.R

class CustomRecyclerNewsAdapter (private val names: List<String>, private val descriptions: List<String>) :
    RecyclerView.Adapter<CustomRecyclerNewsAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_news_name)
        val descTextView: TextView = itemView.findViewById(R.id.text_news_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = names[position]
        holder.descTextView.text = descriptions[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }

}