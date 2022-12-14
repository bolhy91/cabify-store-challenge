package com.bolhy91.cabifystore.data.remote

import com.bolhy91.cabifystore.data.remote.dto.ProductListDto
import retrofit2.http.GET

interface CabifyStoreApi {
    @GET("6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/Products.json")
    suspend fun getProducts(): ProductListDto
}