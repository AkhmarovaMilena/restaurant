package com.example.restaurant2.data.repository

import com.example.restaurant2.data.database.GetTableDatabase
import com.example.restaurant2.data.model.RestaurantModel
import com.example.restaurant2.data.model.toDomainModel

class DatabaseRepository(private val database: GetTableDatabase) {
    fun getAllRestaurants() = database.restaurantDao().getRestaurantAll().map { it.toDomainModel() }
    fun getRestaurantById(id: Int) = database.restaurantDao().getRestaurantById(id).toDomainModel()
    fun insertRestaurants(
        rest1: RestaurantModel,
        rest2: RestaurantModel,
        rest3: RestaurantModel,
        rest4: RestaurantModel,
        rest5: RestaurantModel
    ) = database.restaurantDao().insertAll(rest1, rest2, rest3, rest4, rest5)
    fun deleteAll() = database.restaurantDao().deleteAll()

}