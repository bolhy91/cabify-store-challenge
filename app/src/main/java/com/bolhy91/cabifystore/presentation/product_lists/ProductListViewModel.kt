package com.bolhy91.cabifystore.presentation.product_lists

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.cabifystore.domain.repository.ProductRepository
import com.bolhy91.cabifystore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _state: MutableState<ProductListState> = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productRepository.getProducts()
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                error = result.message,
                                products = emptyList()
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = _state.value.copy(
                                isLoading = false
                            )
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                _state.value = _state.value.copy(
                                    products = result.data,
                                    isLoading = false,
                                    error = null
                                )
                            }
                        }
                    }
                }
        }
    }
}