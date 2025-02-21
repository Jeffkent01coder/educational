package com.jeff.educational.model

data class ProductData(
    val productId : String,
    val productImage : Int? = 0,
    val productTitle : String? = "",
    val productQuantity : String? = "",
    val productDetails : String? = "",
    val productPrice : String? = "",
    val mainCategory : String? = "",
    val subCategory : String? = "",
    val miniCategory : String? = "",
    val promotionTitle : String? = "",
    val categoryImage: Int? = 0
)
