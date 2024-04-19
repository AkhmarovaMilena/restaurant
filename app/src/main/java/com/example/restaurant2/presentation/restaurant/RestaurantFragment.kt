package com.example.restaurant2.presentation.restaurant

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant2.R
import com.example.restaurant2.domain.Restaurant

class RestaurantFragment : Fragment() {
    private val viewModel = RestaurantViewModel()
    private var restaurantId: Int = 0
    private var lastSelectedSlot: Int = 0

    private lateinit var recyclerView: RecyclerView
    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var address: TextView
    private lateinit var description: TextView
    private lateinit var workTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            restaurantId = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.slots_recycler_view)
        image = view.findViewById(R.id.restaurant_image_view)
        title = view.findViewById(R.id.restaurant_title)
        address = view.findViewById(R.id.restaurant_address)
        description = view.findViewById(R.id.restaurant_description)
        workTime = view.findViewById(R.id.work_time)

        observeViewModel()
        viewModel.start(restaurantId)
    }

    private fun observeViewModel() {
        viewModel.restaurantData.observe(
            viewLifecycleOwner
        ) {
            applyData(it)
        }

        viewModel.showReserveDialog.observe(
            viewLifecycleOwner
        ) {}
    }

    @SuppressLint("DiscouragedApi", "UseCompatLoadingForDrawables")
    private fun applyData(restaurant: Restaurant) {

        context?.resources?.let {
            val resourceId = it.getIdentifier(
                restaurant.imageUrl, "drawable",
                context?.packageName
            )
            image.setImageDrawable(it.getDrawable(resourceId))
        }
        title.text = restaurant.name
        address.text = restaurant.address
        description.text = restaurant.description
        workTime.text = restaurant.workingTime

        recyclerView.addItemDecoration(AdaptiveSpacingItemDecoration(50))
        recyclerView.adapter =
            SlotAdapter(generateSlotsList(),
                SlotAdapter.OnClickListener {
                    recyclerView[lastSelectedSlot].background =
                        context?.resources?.getDrawable(R.drawable.bg_slot_normal)
                    recyclerView[it].background =
                        context?.resources?.getDrawable(R.drawable.bg_slot_selected)
                    lastSelectedSlot = it
                }
            )
    }

    private fun generateSlotsList(): ArrayList<Pair<String, Boolean>> {
        val courseList = ArrayList<Pair<String, Boolean>>()
        courseList.add(Pair("09:00", true))
        courseList.add(Pair("11:00", false))
        courseList.add(Pair("13:00", false))
        courseList.add(Pair("14:00", false))
        courseList.add(Pair("15:00", false))
        courseList.add(Pair("16:00", false))
        courseList.add(Pair("18:00", false))
        courseList.add(Pair("20:00", false))
        courseList.add(Pair("22:00", false))
        return courseList
    }

    companion object {
        const val ARG_ID = "restaurant_id"

        @JvmStatic
        fun newInstance(param1: Int) =
            RestaurantFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, param1)
                }
            }
    }
}