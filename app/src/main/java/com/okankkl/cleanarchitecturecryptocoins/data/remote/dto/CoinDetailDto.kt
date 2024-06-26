package com.okankkl.cleanarchitecturecryptocoins.data.remote.dto

import com.okankkl.cleanarchitecturecryptocoins.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail() : CoinDetail {
    return CoinDetail(
        id = id,
        name = name,
        description = description,
        logo = logo,
        started_at = started_at,
        symbol = symbol,
        rank = rank,
        tags = tags.map { it.name },
        team = team,
        hash_algorithm = hash_algorithm,
        is_active = is_active
    )
}