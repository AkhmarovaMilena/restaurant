package com.example.restaurant2.presentation.mainpage

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R
import com.example.restaurant2.domain.Restaurant

class RestaurantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.title)
    private val addressAndTime: TextView = itemView.findViewById(R.id.address_and_time)
    private val image: ImageView = itemView.findViewById(R.id.image_view)

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    fun bind(restaurant: Restaurant) {
        val addressAndTimeText = restaurant.address + COMMA + SPACE + restaurant.workingTime
        val resourceId = itemView.resources.getIdentifier(
            restaurant.imageUrl, "drawable",
            itemView.context.packageName
        )

        title.text = restaurant.name
        addressAndTime.text = addressAndTimeText
        image.setImageDrawable(itemView.resources.getDrawable(resourceId))
    }

    companion object {
        private const val SPACE = " "
        private const val COMMA = ","
    }
}