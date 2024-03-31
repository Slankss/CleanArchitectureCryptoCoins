package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_list.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dagger.Provides

@Composable
fun SearchBar(
    text : String,
    modifier : Modifier,
    onValueChange : (String) -> Unit
){
    
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { value -> onValueChange(value) },
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.White
        )
    )
    
}


@Composable
@Preview
fun SearchBarPreview(){
    SearchBar(
        text = "Bitcoin",
        modifier = Modifier,
    ){

    }
}