package com.example.currencyapp.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.model.nal.NalichkaItem
import kotlinx.android.synthetic.main.item_money_layout.view.*

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

    private var listStart = emptyList<NalichkaItem>()

    class StartViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.item_name.text = listStart[position].ccy
        holder.itemView.item_buy.text = listStart[position].buy
        holder.itemView.item_sale.text = listStart[position].sale
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NalichkaItem>) {
        listStart = list
        notifyDataSetChanged()
    }
}