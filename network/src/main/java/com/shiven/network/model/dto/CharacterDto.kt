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
        "male" -> CharacterGender.Male
        "female" -> CharacterGender.Female
        "other" -> CharacterGender.Other
        "unknown" -> CharacterGender.Unknown
        else -> CharacterGender.Unknown
    }
    val raceSpecies = when(race.lowercase()){
        "saiyan" -> Race.Saiyan
        "human" -> Race.Human
        "namekian" -> Race.Namekian
        "frieza race" -> Race.Frieza_Race
        "jiren race" -> Race.Jiren_Race
        "android" -> Race.Android
        "god" -> Race.God
        "angel" -> Race.God
        "majin" -> Race.Evil
        "evil" -> Race.Evil
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