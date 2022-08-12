package com.bolhy91.cabifystore.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.bolhy91.cabifystore.domain.model.Product

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object ProductsList : Destination("products")
    object ProductDetail : Destination("productDetail")
    object Shopping : Destination("shopping")
}