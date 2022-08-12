package com.bolhy91.cabifystore.utils

import androidx.annotation.DrawableRes
import com.bolhy91.cabifystore.R

data class Menu(val id: Int, val title: String, @DrawableRes val icon: Int, val url: String)

val menuItems: List<Menu> = listOf(
    Menu(1, "Home", R.drawable.ic_home, "products"),
    Menu(2, "Shopping", R.drawable.ic_bag, "shopping"),
)