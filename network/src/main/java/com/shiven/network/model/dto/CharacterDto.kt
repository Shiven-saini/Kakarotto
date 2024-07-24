package com.shiven.network.model.dto

import com.shiven.network.model.domain.Character
import com.shiven.network.model.domain.CharacterGender
import com.shiven.network.model.domain.Race
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val affiliation: String,
    val description: String,
    val gender: String,
    val id: Int,
    val image: String,
    val ki: String,
    val maxKi: String,
    val name: String,
    val originPlanet: OriginPlanet,
    val race: String,
    val transformations: List<Transformation>
)


fun CharacterDto.toDomainCharacter() : Character {
    val characterGender = when(gender.lowercase()){
        "Male" -> CharacterGender.Male
        "Female" -> CharacterGender.Female
        "Other" -> CharacterGender.Other
        "Unknown" -> CharacterGender.Unknown
        else -> CharacterGender.Unknown
    }
    val raceSpecies = when(race.lowercase()){
        "Saiyan" -> Race.Saiyan
        "Human" -> Race.Human
        "Namekian" -> Race.Namekian
        "Frieza Race" -> Race.Frieza_Race
        "Jiren Race" -> Race.Jiren_Race
        "Android" -> Race.Android
        "God" -> Race.God
        "Angel" -> Race.God
        "Majin" -> Race.Evil
        "Evil" -> Race.Evil
        else -> Race.Unknown
    }
    return Character(
        id = id,
        name = name,
        kiLevel = ki,
        race = raceSpecies,
        gender = characterGender,
        image = image,
        planetId = originPlanet.id,
        planetName = originPlanet.name,
        isPlanetDestroyed = originPlanet.isDestroyed
    )
}