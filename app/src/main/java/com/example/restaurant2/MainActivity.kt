package com.example.restaurant2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurant2.data.model.RestaurantModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.databaseRepository.deleteAll()
        addMockRestaurantsToDB()
        setContentView(R.layout.activity_main)
        window.decorView.setBackgroundColor(Color.BLACK)
    }

    private fun addMockRestaurantsToDB() {
        App.databaseRepository.insertRestaurants(
            rest1 = RestaurantModel(
                1,
                "LILA",
                "lila",
                "Москва, ул. Сретенка, 22/1с1",
                "09:00–23:00",
                "Авторская кухня в новом прочтении, с элементами junk food, суши-баром, и использованием интересных техник и сочетаний.\nВ интерьере пространства паназиатского ресторана заложена история о расколе материков. Эта идея отражается в каждом элементе интерьера."
            ),
            rest2 = RestaurantModel(
                2,
                "J’Pan",
                "jpan",
                "Москва, Трубная ул., 21",
                "10:00–23:00",
                "Описание ресторана"
            ),
            rest3 = RestaurantModel(
                3,
                "Хорошая девочка",
                "good_girl",
                "Москва, Малая Бронная ул., 10",
                "09:00–00:00",
                "Описание ресторана"
            ),
            rest4 = RestaurantModel(
                4,
                "[KU:]",
                "ku",
                " Пресненская наб., 10, стр. 2",
                "08:00–00:00",
                "Описание ресторана"
            ),
            rest5 = RestaurantModel(
                5,
                "White Rabbit",
                "white_rabbit",
                "Москва, Смоленская пл., 3",
                "12:00–00:00",
                "Описание ресторана"
            )
        )
    }
}