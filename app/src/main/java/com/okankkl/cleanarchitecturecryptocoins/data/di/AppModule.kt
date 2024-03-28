package com.okankkl.cleanarchitecturecryptocoins.data.di

import com.okankkl.cleanarchitecturecryptocoins.common.Constants
import com.okankkl.cleanarchitecturecryptocoins.data.remote.CoinKaprikaApi
import com.okankkl.cleanarchitecturecryptocoins.data.repository.CoinRepositoryImp
import com.okankkl.cleanarchitecturecryptocoins.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi() : CoinKaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinKaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinKaprikaApi) : CoinRepository {
        return CoinRepositoryImp(api)
    }

}