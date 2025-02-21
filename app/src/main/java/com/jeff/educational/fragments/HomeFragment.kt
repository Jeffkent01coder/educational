package com.jeff.educational.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeff.educational.R
import com.jeff.educational.adapters.PromotionAdapter
import com.jeff.educational.databinding.FragmentHomeBinding
import com.jeff.educational.model.ProductData
import com.jeff.educational.ui.Checkouts

class HomeFragment : Fragment(),  PromotionAdapter.OnPromoClickListener {
    private lateinit var binding: FragmentHomeBinding

    //adapter
    private lateinit var adapter1: PromotionAdapter

    //models
    private lateinit var promoArrayList: ArrayList<ProductData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.payment.setOnClickListener {
            val intent = Intent(requireActivity(), Checkouts::class.java)
            startActivity(intent)
        }

        dataIntialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler1 = binding.promotionRecycler
        recycler1.layoutManager = layoutManager
        recycler1.setHasFixedSize(true)
        adapter1 = PromotionAdapter(promoArrayList, this)
        recycler1.adapter = adapter1
        adapter1.notifyDataSetChanged()

    }

    override fun onPromoClick(product: ProductData, position: Int) {
       Toast.makeText(requireActivity(), "You have clicked on this items", Toast.LENGTH_SHORT).show()
    }

    private fun dataIntialize() {
        promoArrayList = arrayListOf(
            ProductData("", R.drawable.bmw, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.audi, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.car, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.benz, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.car, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.bmw, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.audi, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.benz, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
        )
    }


}