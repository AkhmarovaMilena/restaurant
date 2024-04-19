package com.example.restaurant2.presentation.restaurant

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R

class SlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val slotTime: TextView = itemView.findViewById(R.id.slot_time)

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(slot: Pair<String, Boolean>) {

        slotTime.text = slot.first

        if (slot.second) {
            itemView.background = itemView.context?.resources?.getDrawable(R.drawable.bg_slot_selected)
        } else {
            itemView.background = itemView.context?.resources?.getDrawable(R.drawable.bg_slot_normal)
        }
    }
}