package com.example.practicappc.data.remote.dto

import com.example.parcial2ppc.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("weight") val weight: Int
) {
    fun toDomain(): Pokemon = Pokemon(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        weightKg = weight / 10.0
    )
}
