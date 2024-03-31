package com.okankkl.cleanarchitecturecryptocoins.domain.use_case.search_coin

import com.okankkl.cleanarchitecturecryptocoins.domain.model.Coin
import com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list.CoinListState
import javax.inject.Inject

class SearchCoinUseCase @Inject constructor() {
    fun search(coins : List<Coin>,name : String) : CoinListState{

        if(name.isBlank()){
            return CoinListState(coins = coins)
        }

        val searchedCoins = coins.filter { it.is_active && it.name.lowercase()
            .contains(name.lowercase()) }
            .sortedBy { it.rank }
        if(searchedCoins.isNotEmpty()){
            return CoinListState(coins =searchedCoins)
        }
        return CoinListState(error = "Could not find searched coin")
    }
}