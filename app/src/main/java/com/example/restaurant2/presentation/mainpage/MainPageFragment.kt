package com.example.restaurant2.presentation.mainpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R
import com.example.restaurant2.domain.Restaurant
import com.example.restaurant2.presentation.restaurant.RestaurantFragment

class MainPageFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel = MainPageViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        observeViewModel()
        viewModel.start()
    }

    private fun observeViewModel() {
        viewModel.restaurantsData.observe(
            viewLifecycleOwner
        ) {
            applyData(it)
        }
    }

    private fun applyData(restaurantsList: List<Restaurant>) {
        recyclerView.adapter =
            RestaurantsAdapter(restaurantsList,
                RestaurantsAdapter.OnClickListener {
                    navigateToRestaurant(it.id)
                }
            )
    }

    private fun navigateToRestaurant(restaurantId: Int) {
        view?.let {
            val bundle = bundleOf(RestaurantFragment.ARG_ID to restaurantId)
            Navigation.findNavController(it).navigate(R.id.navigate_to_restaurant_fragment, bundle)
        }
    }
}