package com.bolhy91.cabifystore.domain.repository

import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<Resource<List<Product>>>
}