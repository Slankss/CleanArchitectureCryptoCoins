package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okankkl.cleanarchitecturecryptocoins.domain.model.Coin

@Composable
fun CoinListItem(
    coin : Coin,
    onClick : () -> Unit
){

    Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 10.dp, vertical = 20.dp)
           .clickable {
               onClick()
           },
       horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier
                .weight(8f),
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            fontSize = 18.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic
        )
        Text(
            modifier = Modifier
                .weight(2f)
                .align(Alignment.CenterVertically),
            text = if(coin.is_active) "active" else "inactive",
            color = if(coin.is_active) Color.Green else MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }

}