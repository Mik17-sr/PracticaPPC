package com.example.practicappc.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2ppc.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonUiState>(PokemonUiState.Loading)
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {
        searchPokemon("charmander")
    }

    fun searchPokemon(name: String) {
        viewModelScope.launch {
            _uiState.value = PokemonUiState.Loading
            getPokemonUseCase(name)
                .onSuccess { pokemon -> _uiState.value = PokemonUiState.Success(pokemon) }
                .onFailure { error ->
                    _uiState.value = PokemonUiState.Error(error.message ?: "Error al consultar API")
                }
        }
    }
}
