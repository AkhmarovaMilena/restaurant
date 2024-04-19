package com.example.restaurant2.presentation.mainpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R
import com.example.restaurant2.domain.Restaurant

class RestaurantsAdapter(
    private val restaurantsList: List<Restaurant>,
    private val onRestaurantClickListener: OnClickListener
) : RecyclerView.Adapter<RestaurantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list_item, parent, false)
        return RestaurantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onRestaurantClickListener.onClick(restaurant = restaurantsList[position])
        }
        holder.bind(restaurantsList[position])
    }

    override fun getItemCount(): Int {
        return restaurantsList.size
    }

    class OnClickListener(val clickListener: (restaurant: Restaurant) -> Unit) {
        fun onClick(restaurant: Restaurant) = clickListener(restaurant)
    }
}