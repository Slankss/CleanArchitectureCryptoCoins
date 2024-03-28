package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.okankkl.cleanarchitecturecryptocoins.presentation.Screen
import com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list.components.CoinListItem


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinListScreen (
    navController: NavController,
    viewModel : CoinListViewModel = hiltViewModel()
){

    val state = viewModel.state.collectAsState().value

    Box(
       modifier = Modifier
           .fillMaxSize()
    ){

        LazyColumn(){
            items(state.coins){coin ->
                CoinListItem(coin = coin) {
                    navController.navigate(Screen.CoinDetailScreen.route + "/" + coin.id)
                }
            }
        }

        if(state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
    }

}