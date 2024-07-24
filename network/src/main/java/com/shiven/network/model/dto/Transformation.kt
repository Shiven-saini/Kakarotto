package com.shiven.network.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Transformation(
    val id: Int,
    val image: String,
    val ki: String,
    val name: String
)