package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_detail

import com.okankkl.cleanarchitecturecryptocoins.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
