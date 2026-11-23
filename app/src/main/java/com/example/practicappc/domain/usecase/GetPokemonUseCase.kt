package com.example.parcial2ppc.domain.usecase

import com.example.parcial2ppc.domain.model.Pokemon
import com.example.parcial2ppc.domain.repository.PokemonRepository

class GetPokemonUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(name: String): Result<Pokemon> {
        val cleanName = name.trim().lowercase()
        if (cleanName.isBlank()) {
            return Result.failure(IllegalArgumentException("El nombre no puede estar vacío"))
        }
        return repository.getPokemon(cleanName)
    }
}
