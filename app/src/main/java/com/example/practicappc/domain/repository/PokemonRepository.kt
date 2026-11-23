package com.example.parcial2ppc.domain.repository

import com.example.parcial2ppc.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemon(name: String): Result<Pokemon>
}