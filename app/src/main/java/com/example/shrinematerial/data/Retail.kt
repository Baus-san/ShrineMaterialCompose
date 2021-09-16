package com.example.shrinematerial.data

import androidx.annotation.DrawableRes
import com.example.shrinematerial.R

data class Retail(
    val productName: String,
    @DrawableRes val productImgIdRes: Int,
    @DrawableRes val brandIconIdRes: Int,
    val price: Int
)

val RetailItems = listOf(
    Retail(
        productName = "High Tea Cup",
        productImgIdRes = R.drawable.photo_high,
        brandIconIdRes = R.drawable.ic_brand_6_24,
        price = 36
    ),
    Retail(
        productName = "Hopscotch Shoes",
        productImgIdRes = R.drawable.photo_hopscotch,
        brandIconIdRes = R.drawable.ic_brand_mal_24,
        price = 134
    ),
    Retail(
        productName = "OK Glow Lamp",
        productImgIdRes = R.drawable.photo_ok,
        brandIconIdRes = R.drawable.ic_brand_alpi_24,
        price = 20
    ),
    Retail(
        productName = "Dusty Pink Satchel",
        productImgIdRes = R.drawable.photo_dusty,
        brandIconIdRes = R.drawable.ic_brand_squiggle_24,
        price = 133
    ),
    Retail(
        productName = "Bamboo Turntables",
        productImgIdRes = R.drawable.photo_bamboo,
        brandIconIdRes = R.drawable.ic_brand_squiggle_24,
        price = 133
    ),
    Retail(
        productName = "Flow Shirt Blouse",
        productImgIdRes = R.drawable.photo_flow,
        brandIconIdRes = R.drawable.ic_brand_lmb_24,
        price = 240
    ),

)
