package com.jeff.educational.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeff.educational.R
import com.jeff.educational.adapters.ViewPagerAdapter
import com.jeff.educational.chechoutfragments.CardFragment
import com.jeff.educational.chechoutfragments.MpesaFragment
import com.jeff.educational.chechoutfragments.OnDeliveryFragment
import com.jeff.educational.databinding.ActivityCheckoutsBinding

class Checkouts : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCheckoutsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(binding.root)

        setUpTabs()

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }
    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OnDeliveryFragment(), "Pay On Delivery")
        adapter.addFragment(MpesaFragment(), "Mpesa")
        adapter.addFragment(CardFragment(), "Card")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}