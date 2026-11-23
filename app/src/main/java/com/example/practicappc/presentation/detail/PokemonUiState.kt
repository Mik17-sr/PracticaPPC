package com.example.practicappc.presentation.detail

import com.example.parcial2ppc.domain.model.Pokemon

sealed interface PokemonUiState {
    data object Loading : PokemonUiState
    data class Success(val pokemon: Pokemon) : PokemonUiState
    data class Error(val message: String) : PokemonUiState
}
