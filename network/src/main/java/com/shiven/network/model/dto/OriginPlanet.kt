package com.shiven.network.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class OriginPlanet(
    val description: String,
    val id: Int,
    val image: String,
    val isDestroyed: Boolean,
    val name: String
)