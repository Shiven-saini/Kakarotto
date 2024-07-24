package com.shiven.network.model.domain

// Add transformations later on as per need.
// TODO: KiLevel map to different colors
data class Character(
    val id: Int,
    val name: String,
    val kiLevel: String,
    val race: Race,
    val gender: CharacterGender,
    val image: String,
    val planetId: Int,
    val planetName: String,
    val isPlanetDestroyed: Boolean
)