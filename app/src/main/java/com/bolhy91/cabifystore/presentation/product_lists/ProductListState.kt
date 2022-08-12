package com.bolhy91.cabifystore.presentation.product_lists

import com.bolhy91.cabifystore.domain.model.Product

data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
