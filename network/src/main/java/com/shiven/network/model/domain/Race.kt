package com.shiven.network.model.domain


// TODO: ADD a custom icon for race
// club god and angel in same category
// club majin and evil in same category
// map else to unknown
sealed class Race(val displayName: String, val color: Long) {

    object Saiyan: Race(displayName="Saiyan", color = 0xffffffff)
    object Human: Race(displayName="Human", color = 0xffffffff)
    object Namekian: Race(displayName = "Namekian", color = 0xffffffff)
    object Frieza_Race: Race(displayName = "Frieza Race", color = 0xffffffff)
    object God: Race(displayName = "God", color = 0xffffffff)
    object Android: Race(displayName = "Android", color = 0xffffffff)
    object Jiren_Race: Race(displayName = "Jiren Race", color = 0xffffffff)
    object Evil: Race(displayName = "Evil", color = 0xffffffff)
    object Unknown: Race(displayName = "Unknown", color = 0xffffffff)
}
