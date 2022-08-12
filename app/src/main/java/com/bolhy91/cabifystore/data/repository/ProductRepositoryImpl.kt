package com.bolhy91.cabifystore.data.repository

import android.util.Log
import com.bolhy91.cabifystore.data.mapper.toProduct
import com.bolhy91.cabifystore.data.remote.CabifyStoreApi
import com.bolhy91.cabifystore.domain.model.Product
import com.bolhy91.cabifystore.domain.repository.ProductRepository
import com.bolhy91.cabifystore.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val cabifyStoreApi: CabifyStoreApi
) : ProductRepository {
    override suspend fun getProducts(): Flow<Resource<List<Product>>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteProducts = try {
                val results = cabifyStoreApi.getProducts()
                results
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data ${e.message}"))
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data http: ${e.message}"))
                null
            }
            remoteProducts?.let { results ->
                emit(Resource.Success(data = results.products.map { it.toProduct() }))
                emit(Resource.Loading(false))
            }
        }
    }
}