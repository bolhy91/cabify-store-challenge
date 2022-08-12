package com.bolhy91.cabifystore.di

import com.bolhy91.cabifystore.data.remote.CabifyStoreApi
import com.bolhy91.cabifystore.utils.Api.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideCabifyStoreApi(retrofit: Retrofit): CabifyStoreApi {
        return retrofit.create(CabifyStoreApi::class.java)
    }
}