package com.okankkl.cleanarchitecturecryptocoins.domain.model

import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.Tag
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.TeamMember

data class CoinDetail (
    val id: String,
    val name: String,
    val description: String,
    val logo: String,
    val started_at: String,
    val is_active : Boolean,
    val symbol: String,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
    val hash_algorithm: String,
)