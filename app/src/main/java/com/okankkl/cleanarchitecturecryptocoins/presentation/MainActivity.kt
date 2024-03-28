package com.okankkl.cleanarchitecturecryptocoins.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.okankkl.cleanarchitecturecryptocoins.presentation.coin_detail.CoinDetailScreen
import com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list.CoinListScreen
import com.okankkl.cleanarchitecturecryptocoins.ui.theme.BackgroundCOlor
import com.okankkl.cleanarchitecturecryptocoins.ui.theme.CleanArchitectureCryptoCoinsTheme
import dagger.hilt.android.AndroidEntryPoint

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureCryptoCoinsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundCOlor
                ) {
                    CoinKaprikaApp()
                }
            }
        }
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinKaprikaApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route){

        composable(route = Screen.CoinListScreen.route){
            CoinListScreen(navController = navController)
        }

        composable(route = Screen.CoinDetailScreen.route + "/{coinId}" ){
            CoinDetailScreen(navController = navController)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureCryptoCoinsTheme {
        CoinKaprikaApp()
    }
}