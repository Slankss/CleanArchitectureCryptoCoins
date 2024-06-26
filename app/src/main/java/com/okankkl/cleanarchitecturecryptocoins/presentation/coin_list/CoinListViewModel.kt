package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.cleanarchitecturecryptocoins.common.Resource
import com.okankkl.cleanarchitecturecryptocoins.domain.model.Coin
import com.okankkl.cleanarchitecturecryptocoins.domain.use_case.get_coins.GetCoinsUseCase
import com.okankkl.cleanarchitecturecryptocoins.domain.use_case.search_coin.SearchCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val searchCoinUseCase: SearchCoinUseCase
) : ViewModel(){

    private var coinList = emptyList<Coin>()
    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()

    init {
        getCoins()
    }

    fun searchCoin(name : String){
       _state.value = searchCoinUseCase.search(coins = coinList,name = name)
    }
    private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    coinList = result.data ?: emptyList()
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    coinList = emptyList()
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    coinList = emptyList()
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}