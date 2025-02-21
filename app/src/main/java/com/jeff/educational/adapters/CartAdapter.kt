package com.jeff.educational.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff.educational.databinding.CartItemBinding
import com.jeff.educational.model.ProductData


class CartAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnCartClickListener
) :
    RecyclerView.Adapter<CartAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val cartItemBinding: CartItemBinding) :
        RecyclerView.ViewHolder(cartItemBinding.root) {

        fun setData(product: ProductData, action: OnCartClickListener) {
            cartItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice

                btnAdd.setOnClickListener {
                    action.onAddClick(product, adapterPosition)
                }

                btnSubtract.setOnClickListener {
                    action.onSubtractClick(product, adapterPosition)
                }

                deleteTask.setOnClickListener {
                    action.onDeleteClick(product, adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCartClickListener {
        fun onAddClick(product: ProductData, position: Int)
        fun onSubtractClick(product: ProductData, position: Int)
        fun onDeleteClick(product: ProductData, position: Int)
    }
}