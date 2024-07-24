package com.shiven.network.model.domain

sealed class CharacterGender(val displayName: String) {

    object Male: CharacterGender("Male")
    object Female: CharacterGender("Female")
    object Other: CharacterGender("Other")
    object Unknown: CharacterGender("Not Known yet")

}