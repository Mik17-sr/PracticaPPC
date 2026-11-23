package com.example.practicappc.data.remote

import com.example.practicappc.data.remote.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{name}")
    suspend fun fetchPokemon(@Path("name") pokemonName: String): PokemonDto
}
