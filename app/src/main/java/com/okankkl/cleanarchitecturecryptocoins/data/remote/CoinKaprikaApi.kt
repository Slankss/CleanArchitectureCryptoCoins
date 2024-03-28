package com.okankkl.cleanarchitecturecryptocoins.data.remote

import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDetailDto
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinKaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{id}")
    suspend fun getCoinById(@Path("id") coinId : String) : CoinDetailDto
}