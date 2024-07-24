package com.shiven.network.model.domain

import com.shiven.network.R
import kotlinx.serialization.Serializable


// TODO: ADD a custom icon for race
// club god and angel in same category
// club majin and evil in same category
// map else to unknown
@Serializable
sealed class Race(val displayName: String, val color: Int) {
    object Saiyan: Race(displayName="Saiyan", color = R.color.saiyan)
    object Human: Race(displayName = "Human", color = R.color.human)
    object Namekian: Race(displayName = "Namekian", color = R.color.namekian)
    object Frieza_Race: Race(displayName = "Frieza Race", color = R.color.frieza_race)
    object God: Race(displayName = "God", color = R.color.god)
    object Android: Race(displayName = "Android", color = R.color.android)
    object Jiren_Race: Race(displayName = "Jiren Race", color = R.color.jiren_race)
    object Evil: Race(displayName = "Evil", color = R.color.evil)
    object Unknown: Race(displayName = "Unknown", color = R.color.unknown)
}
