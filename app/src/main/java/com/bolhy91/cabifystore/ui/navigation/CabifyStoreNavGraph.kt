package com.bolhy91.cabifystore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.presentation.product_detail.ProductDetailScreen
import com.bolhy91.cabifystore.presentation.product_lists.ProductListScreen
import com.bolhy91.cabifystore.presentation.shared.SharedViewModel
import com.bolhy91.cabifystore.presentation.shopping.ShoppingScreen

@Composable
fun CabifyStoreNavGraph(navController: NavHostController) {

    val sharedViewModel: SharedViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Destination.ProductsList.route
    ) {
        productsList(navController, selectedProduct = {
            sharedViewModel.product = it
        })
        productDetail(navController, sharedViewModel)
        shopping(navController)
    }
}

fun NavGraphBuilder.productsList(
    navController: NavHostController,
    selectedProduct: (Product) -> Unit
) {
    composable(
        route = Destination.ProductsList.route,
    ) {
        ProductListScreen(
            itemPress = {
                println(it)
                selectedProduct(it)
                navController.navigate(Destination.ProductDetail.route)
            }
        )
    }
}

fun NavGraphBuilder.productDetail(navController: NavHostController, viewModel: SharedViewModel) {
    composable(
        route = Destination.ProductDetail.route,
    ) {

        println("pr ${viewModel.product.toString()}")
        ProductDetailScreen(product = viewModel.product, onBack = {
            navController.navigateUp()
        })
    }
}

fun NavGraphBuilder.shopping(navController: NavHostController) {
    composable(
        route = Destination.Shopping.route
    ) {
        ShoppingScreen()
    }
}