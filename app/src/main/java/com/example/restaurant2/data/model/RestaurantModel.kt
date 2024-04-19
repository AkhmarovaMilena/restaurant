package com.example.restaurant2.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.restaurant2.domain.Restaurant

@Entity(tableName = "restaurants")
data class RestaurantModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "working_time")
    val workingTime: String,
    @ColumnInfo(name = "description")
    val description: String,
)

fun RestaurantModel.toDomainModel() = Restaurant(
    id, name, imageUrl, address, workingTime, description
)