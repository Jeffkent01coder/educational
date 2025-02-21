package com.jeff.educational.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jeff.educational.R
import com.jeff.educational.adapters.CartAdapter
import com.jeff.educational.databinding.FragmentCategoryBinding
import com.jeff.educational.model.ProductData


class CategoryFragment : Fragment(), CartAdapter.OnCartClickListener {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartArrayList: ArrayList<ProductData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CartAdapter(cartArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    private fun dataInitialize() {
        cartArrayList = arrayListOf(
            ProductData("", R.drawable.bmw, "BMW", "3", "", "$ 30000"),
            ProductData("", R.drawable.audi, "Audi", "2 ", "", "$ 20000"),
            ProductData("", R.drawable.car, "Mazda", "1", "", "$ 10000"),
            ProductData("", R.drawable.benz, "Benz", "3", "", "$ 25000"),
            ProductData("", R.drawable.bmw, "BMW", "3", "", "$ 30000"),
            ProductData("", R.drawable.audi, "Audi", "2 ", "", "$ 20000"),
            ProductData("", R.drawable.car, "Mazda", "1", "", "$ 10000"),
            ProductData("", R.drawable.benz, "Benz", "3", "", "$ 25000"),
            )
    }

    override fun onAddClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onSubtractClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "Subtracted", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "Deleted", Toast.LENGTH_SHORT).show()
    }

}