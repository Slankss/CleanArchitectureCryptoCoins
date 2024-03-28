package com.okankkl.cleanarchitecturecryptocoins.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.TeamMember

@Composable
fun TeamListItem(teamMember : TeamMember){
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = teamMember.name,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = teamMember.position,
            fontWeight = FontWeight.Light,
            color = Color.LightGray,
            fontStyle = FontStyle.Italic
        )
        Divider(
            modifier = Modifier.fillMaxWidth().height(1.dp),
            color = Color.LightGray)

    }
}