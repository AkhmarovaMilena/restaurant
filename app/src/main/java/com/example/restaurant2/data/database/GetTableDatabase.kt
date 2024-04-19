package com.example.restaurant2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.restaurant2.data.model.RestaurantModel

@Database(entities = [RestaurantModel::class], version = 1)
abstract class GetTableDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    companion object {
        @Volatile
        private lateinit var instance: GetTableDatabase

        fun getInstance(context: Context): GetTableDatabase {
            synchronized(this) {
                if (!::instance.isInitialized) {
                    instance = Room.databaseBuilder(
                        context,
                        GetTableDatabase::class.java, "get-table-database"
                    ).allowMainThreadQueries().build()
                }
                return instance
            }
        }
    }
}