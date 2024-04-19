package com.example.restaurant2.presentation.mainpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurant2.App
import com.example.restaurant2.domain.Restaurant

class MainPageViewModel: ViewModel() {
    private val database = App.databaseRepository
    val restaurantsData = MutableLiveData<List<Restaurant>>()

    fun start() {
        getRestaurantsList()
    }

    private fun getRestaurantsList() {
        val restaurants = database.getAllRestaurants()
        restaurantsData.postValue(restaurants)
    }
}