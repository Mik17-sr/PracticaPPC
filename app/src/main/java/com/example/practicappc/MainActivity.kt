package com.example.practicappc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial2ppc.domain.usecase.GetPokemonUseCase
import com.example.practicappc.data.remote.RetrofitClient
import com.example.practicappc.data.remote.repository.PokemonRepositoryImpl
import com.example.practicappc.presentation.detail.PokemonScreen
import com.example.practicappc.presentation.detail.PokemonViewModel
import com.example.practicappc.ui.theme.PracticaPPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = PokemonRepositoryImpl(RetrofitClient.api)
        val useCase = GetPokemonUseCase(repository)
        val viewModel = PokemonViewModel(useCase)

        setContent {
            PokemonScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticaPPCTheme {
        Greeting("Android")
    }
}