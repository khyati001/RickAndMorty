package com.example.rickandmorty.retrofit

import com.example.rickandmorty.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

}