package com.example.practicappc.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {
    val state by viewModel.uiState.collectAsState()

    when (val current = state) {
        is PokemonUiState.Loading -> CircularProgressIndicator()
        is PokemonUiState.Success -> {
            Column() {
                Text(text = "#${current.pokemon.id} - ${current.pokemon.name}")
                Text(text = "Peso: ${current.pokemon.weightKg} kg")
            }
        }
        is PokemonUiState.Error -> Text(text = "Error: ${current.message}")
    }
}
