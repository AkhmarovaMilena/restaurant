package com.example.restaurant2.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.restaurant2.data.model.RestaurantModel

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurants")
    fun getRestaurantAll(): List<RestaurantModel>

    @Query("SELECT * FROM restaurants WHERE id LIKE :restaurantId")
    fun getRestaurantById(restaurantId: Int): RestaurantModel

    @Insert
    fun insertAll(vararg restaurants: RestaurantModel)

    @Delete
    fun delete(user: RestaurantModel)

    @Query("DELETE FROM restaurants")
    fun deleteAll()
}