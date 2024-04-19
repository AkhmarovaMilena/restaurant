package com.example.restaurant2

import android.app.Application
import com.example.restaurant2.data.database.GetTableDatabase
import com.example.restaurant2.data.repository.DatabaseRepository

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = GetTableDatabase.getInstance(applicationContext)
        databaseRepository = DatabaseRepository(database)

    }

    companion object {
        lateinit var database: GetTableDatabase
            private set

        lateinit var databaseRepository: DatabaseRepository
            private set
    }
}