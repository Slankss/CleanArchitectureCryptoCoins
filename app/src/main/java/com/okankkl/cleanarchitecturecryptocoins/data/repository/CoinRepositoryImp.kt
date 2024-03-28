package com.okankkl.cleanarchitecturecryptocoins.data.repository

import com.okankkl.cleanarchitecturecryptocoins.data.remote.CoinKaprikaApi
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDetailDto
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.CoinDto
import com.okankkl.cleanarchitecturecryptocoins.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImp @Inject constructor(
    val api: CoinKaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}