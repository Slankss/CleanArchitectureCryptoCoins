package com.okankkl.cleanarchitecturecryptocoins.domain.repository

import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDetailDto
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinDetail(coinId : String) : CoinDetailDto

}