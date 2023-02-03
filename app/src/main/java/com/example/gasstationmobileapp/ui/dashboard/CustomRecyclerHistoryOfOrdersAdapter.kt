package com.example.gasstationmobileapp.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gasstationmobileapp.R

class CustomRecyclerHistoryOfOrdersAdapter (private val names: List<String>,
                                            private val prices: List<String>,
                                            private val counts: List<String>,
                                            private val dates: List<String>) :
    RecyclerView.Adapter<CustomRecyclerHistoryOfOrdersAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_offer_title)
        val priceTextView: TextView = itemView.findViewById(R.id.text_price)
        val countTextView: TextView = itemView.findViewById(R.id.text_count)
        val dateTextView: TextView = itemView.findViewById(R.id.text_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView.text = names[position]
        holder.priceTextView.text = prices[position]
        holder.countTextView.text = counts[position]
        holder.dateTextView.text = dates[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }

}