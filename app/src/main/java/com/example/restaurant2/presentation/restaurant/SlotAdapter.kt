package com.example.restaurant2.presentation.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R

class SlotAdapter(
    private val slots: ArrayList<Pair<String, Boolean>>,
    private val onSlotClickListener: OnClickListener
) : RecyclerView.Adapter<SlotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slot_list_item, parent, false)
        return SlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlotViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onSlotClickListener.onClick(position = position)
        }
        holder.bind(slots[position])
    }

    override fun getItemCount(): Int = slots.size


    class OnClickListener(val clickListener: (position: Int) -> Unit) {
        fun onClick(position: Int) = clickListener(position)
    }
}