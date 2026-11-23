package com.example.practicappc.data.remote.repository

import com.example.parcial2ppc.domain.model.Pokemon
import com.example.parcial2ppc.domain.repository.PokemonRepository
import com.example.practicappc.data.remote.PokeApiService

class PokemonRepositoryImpl(private val api: PokeApiService) : PokemonRepository {
    override suspend fun getPokemon(name: String): Result<Pokemon> {
        return try {
            val dto = api.fetchPokemon(name)
            Result.success(dto.toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}