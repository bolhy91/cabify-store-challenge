package com.bolhy91.cabifystore.presentation.shared

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.bolhy91.cabifystore.domain.model.CartItem
import com.bolhy91.cabifystore.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    // Capture product selected
    var product by mutableStateOf<Product?>(null)

    private fun getShoppingCart(): MutableList<CartItem> {
        return mutableListOf()
    }

    // Shopping Cart
    fun addItem(cartItem: CartItem) {
        val items = getShoppingCart()
        val equalItem = items.singleOrNull { it.product.code == cartItem.product.code }
        if (equalItem == null) {
            cartItem.quantity++
            items.add(cartItem)
        } else {
            equalItem.quantity++
        }
    }

    fun removeItem(cartItem: CartItem) {
        val items = getShoppingCart()
        val target = items.singleOrNull { it.product.code == cartItem.product.code }
        if (target != null) {
            if (target.quantity > 0) {
                items.remove(target)
            }
        }
    }

    fun getShoppingItemsSize(): Int {
        var itemSize = 0
        getShoppingCart().forEach {
            itemSize += it.quantity
        }
        return itemSize
    }
}