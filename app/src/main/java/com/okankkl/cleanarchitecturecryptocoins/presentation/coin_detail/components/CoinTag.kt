package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TagItem(tagName : String){

    Box(
        modifier = Modifier
            .border(1.dp, color = Color.Green, shape = CircleShape)
    ){
        Text(
           modifier = Modifier.padding(7.dp),
           text = tagName,
           color = Color.Green,
           fontSize = 12.sp
        )
    }

}